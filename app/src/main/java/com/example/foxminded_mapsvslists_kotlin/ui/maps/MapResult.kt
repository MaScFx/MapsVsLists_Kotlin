package com.example.foxminded_mapsvslists_kotlin.ui.maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.data.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.ui.ResultItem

@Composable
fun MapResult(
    onBackClick: () -> Unit, result: Map<Int, Int> = HashMap()
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {

            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = stringResource(id = R.string.map_adding_new))
                ResultItem(
                    title = stringResource(id = R.string.type_HashMap),
                    smallItem = false,
                    result = result[Operations.AddingNewHM.ordinal] ?: -1
                )
                Text(text = stringResource(id = R.string.map_search))
                ResultItem(
                    title = stringResource(id = R.string.type_HashMap),
                    smallItem = false,
                    result = result[Operations.SearchHM.ordinal] ?: -1
                )
                Text(text = stringResource(id = R.string.map_removing))
                ResultItem(
                    title = stringResource(id = R.string.type_HashMap),
                    smallItem = false,
                    result = result[Operations.RemovingHM.ordinal] ?: -1
                )
            }

            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = "")
                ResultItem(
                    title = stringResource(id = R.string.type_TreeMap),
                    smallItem = false,
                    result = result[Operations.AddingNewTM.ordinal] ?: -1
                )
                Text(text = "")
                ResultItem(
                    title = stringResource(id = R.string.type_TreeMap),
                    smallItem = false,
                    result = result[Operations.SearchTM.ordinal] ?: -1
                )
                Text(text = "")
                ResultItem(
                    title = stringResource(id = R.string.type_TreeMap),
                    smallItem = false,
                    result = result[Operations.RemovingTM.ordinal] ?: -1
                )
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = onBackClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(16.dp)
            ) {
                Text(text = stringResource(id = R.string.clear))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapResultPreview() {
    MapResult(onBackClick = {})
}