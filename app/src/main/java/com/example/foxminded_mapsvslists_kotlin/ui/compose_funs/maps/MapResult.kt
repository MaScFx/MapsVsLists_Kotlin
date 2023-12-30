package com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.maps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.ResultItem

@Preview
@Composable
fun MapResult(
    onBackClick: () -> Unit = {},
    resultIsReady: Boolean = false,
    result: Map<Int, Int> = HashMap()
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
//                .background(color = Color.Gray)
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
//                    .background(color = Color.Yellow)
            ) {
                ResultItem(title = "HashMap", smallItem = false)
                ResultItem(title = "HashMap", smallItem = false)
                ResultItem(title = "HashMap", smallItem = false)
            }
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
//                    .background(color = Color.Yellow)
            ) {
                ResultItem(title = "ThreeMap", smallItem = false)
                ResultItem(title = "ThreeMap", smallItem = false)
                ResultItem(title = "ThreeMap", smallItem = false)
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = "Back")

            }
        }
    }


}