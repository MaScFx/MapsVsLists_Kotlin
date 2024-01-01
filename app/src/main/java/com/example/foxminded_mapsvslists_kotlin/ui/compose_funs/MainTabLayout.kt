package com.example.foxminded_mapsvslists_kotlin.ui.compose_funs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.collection.TabPageCollection
import com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.maps.TabPageMap
import com.example.foxminded_mapsvslists_kotlin.vm.CollectionViewModel
import com.example.foxminded_mapsvslists_kotlin.vm.MapViewModel
import kotlinx.coroutines.launch

//@Preview(showBackground = true)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainTabLayout(collectionVM: CollectionViewModel, mapVM: MapViewModel) {

    val pagerState = rememberPagerState(pageCount = { HomeTabs.entries.size })
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex.value, modifier = Modifier.fillMaxWidth()
        ) {
            HomeTabs.entries.forEachIndexed() { index, currentTab ->
                Tab(selected = selectedTabIndex.value == index,
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.outline,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(currentTab.ordinal)
                        }
                    },
                    text = { Text(text = currentTab.name) })
            }
        }
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { _ ->
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                if (selectedTabIndex.value == 0) {
                    TabPageCollection(collectionVM)
                } else {
                    TabPageMap(mapVM)
                }
            }
        }
    }
}

enum class HomeTabs {
    COLLECTIONS, MAPS
}
