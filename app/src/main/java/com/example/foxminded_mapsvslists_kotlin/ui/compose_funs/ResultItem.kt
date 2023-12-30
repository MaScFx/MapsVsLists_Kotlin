package com.example.foxminded_mapsvslists_kotlin.ui.compose_funs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true)
@Composable
fun ResultItem(
    title: String = "TypeListOrMaps",
    result: Int = -1,
    smallItem: Boolean = true,
//    modifier: Modifier
) {
    val heightItem = if (smallItem) 70.dp else 100.dp
    val widthItem  = if (smallItem) 130.dp else 200.dp
    val widthProgressBar  = if (smallItem) 40.dp else 64.dp
    OutlinedCard(
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(height = heightItem, width = widthItem)
            .padding(2.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = title, modifier = Modifier.align(Alignment.TopCenter))
            if (result < 0) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(widthProgressBar)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,

                    )
            } else {
                Text(
                    text = result.toString(),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }

    }
}