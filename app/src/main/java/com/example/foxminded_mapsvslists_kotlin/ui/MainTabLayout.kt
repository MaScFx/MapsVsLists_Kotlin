package com.example.foxminded_mapsvslists_kotlin.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.data.repository.CollectionsOperationsRunner
import com.example.foxminded_mapsvslists_kotlin.data.repository.MapsOperationsRunner
import com.example.foxminded_mapsvslists_kotlin.ui.collection.CollectionViewModel
import com.example.foxminded_mapsvslists_kotlin.ui.collection.TabPageCollection
import com.example.foxminded_mapsvslists_kotlin.ui.maps.MapViewModel
import com.example.foxminded_mapsvslists_kotlin.ui.maps.TabPageMap
import com.example.foxminded_mapsvslists_kotlin.ui.theme.Black
import com.example.foxminded_mapsvslists_kotlin.ui.theme.Orange
import com.example.foxminded_mapsvslists_kotlin.ui.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainTabLayout(collectionVM: CollectionViewModel, mapVM: MapViewModel) {

    val pagerState = rememberPagerState(pageCount = { HomeTabs.entries.size })
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }
    val scope = rememberCoroutineScope()
    val textTitle = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Orange)
        ) {
            Text(
                text = textTitle.value,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
//                fontFamily = FontFamily(Font(R.font.poppins_medium))
            )

        }
        TabRow(
            selectedTabIndex = selectedTabIndex.value, modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topEnd = 0.dp,
                        topStart = 0.dp,
                        bottomStart = 9.dp,
                        bottomEnd = 9.dp
                    )
                ),
            containerColor = Orange
        ) {

            HomeTabs.entries.forEachIndexed() { index, currentTab ->
                val backgroundColor = if (index == selectedTabIndex.value) Black else Orange
                Tab(selected = selectedTabIndex.value == index,
                    modifier = Modifier.background(backgroundColor),
                    selectedContentColor = White,
                    unselectedContentColor = Black,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(currentTab.ordinal)
                        }
                    },
                    text = {
                        Text(
                            text = currentTab.name,
                            fontSize = 14.sp,
//                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    })
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
                    textTitle.value =
                        if (collectionVM.uiState.collectAsState().value.waitingForUserInput) {
                            stringResource(R.string.activity)
                        } else {
                            stringResource(R.string.collections_maps)
                        }
                    TabPageCollection(collectionVM)
                } else {
                    textTitle.value =
                        if (mapVM.uiState.collectAsState().value.waitingForUserInput) {
                            stringResource(R.string.activity)
                        } else {
                            stringResource(R.string.collections_maps)
                        }
                    TabPageMap(mapVM)
                }
            }
        }
    }
}

enum class HomeTabs {
    COLLECTIONS, MAPS
}

@Composable
@Preview(showBackground = true)
fun preview() {
    MainTabLayout(
        CollectionViewModel(CollectionsOperationsRunner()), MapViewModel(MapsOperationsRunner())
    )
}
