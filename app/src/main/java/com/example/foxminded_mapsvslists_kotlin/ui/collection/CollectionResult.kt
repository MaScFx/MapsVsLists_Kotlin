package com.example.foxminded_mapsvslists_kotlin.ui.collection

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
import androidx.compose.ui.unit.sp
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.data.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.ui.ResultItem

@Composable
fun CollectionResult(
    onBackClick: () -> Unit, result: Map<Int, Int> = HashMap()
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.col_add_beginning), fontSize = 20.sp)
            Row {
                ResultItem(
                    title = stringResource(id = R.string.type_AL),
                    smallItem = true,
                    result = result[Operations.AddingBeginningAL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_LL),
                    smallItem = true,
                    result = result[Operations.AddingBeginningLL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_CoW),
                    smallItem = true,
                    result = result[Operations.AddingBeginningCoW.ordinal] ?: -1
                )
            }

            Text(text = stringResource(id = R.string.col_add_middle))
            Row {
                ResultItem(
                    title = stringResource(id = R.string.type_AL),
                    smallItem = true,
                    result = result[Operations.AddingMiddleAL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_LL),
                    smallItem = true,
                    result = result[Operations.AddingMiddleLL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_CoW),
                    smallItem = true,
                    result = result[Operations.AddingMiddleCoW.ordinal] ?: -1
                )
            }

            Text(text = stringResource(id = R.string.col_add_end))
            Row {
                ResultItem(
                    title = stringResource(id = R.string.type_AL),
                    smallItem = true,
                    result = result[Operations.AddingEndAL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_LL),
                    smallItem = true,
                    result = result[Operations.AddingEndLL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_CoW),
                    smallItem = true,
                    result = result[Operations.AddingEndCoW.ordinal] ?: -1
                )
            }

            Text(text = stringResource(id = R.string.col_search))
            Row {
                ResultItem(
                    title = stringResource(id = R.string.type_AL),
                    smallItem = true,
                    result = result[Operations.SearchAL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_LL),
                    smallItem = true,
                    result = result[Operations.SearchLL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_CoW),
                    smallItem = true,
                    result = result[Operations.SearchCoW.ordinal] ?: -1
                )
            }

            Text(text = stringResource(id = R.string.col_removing_beginning))
            Row {
                ResultItem(
                    title = stringResource(id = R.string.type_AL),
                    smallItem = true,
                    result = result[Operations.RemovingBeginningAL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_LL),
                    smallItem = true,
                    result = result[Operations.RemovingBeginningLL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_CoW),
                    smallItem = true,
                    result = result[Operations.RemovingBeginningCoW.ordinal] ?: -1
                )
            }

            Text(text = stringResource(id = R.string.col_removing_middle))

            Row {
                ResultItem(
                    title = stringResource(id = R.string.type_AL),
                    smallItem = true,
                    result = result[Operations.RemovingMiddleAL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_LL),
                    smallItem = true,
                    result = result[Operations.RemovingMiddleLL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_CoW),
                    smallItem = true,
                    result = result[Operations.RemovingMiddleCoW.ordinal] ?: -1
                )
            }
            Text(text = stringResource(id = R.string.col_removing_end))

            Row {
                ResultItem(
                    title = stringResource(id = R.string.type_AL),
                    smallItem = true,
                    result = result[Operations.RemovingEndAL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_LL),
                    smallItem = true,
                    result = result[Operations.RemovingEndLL.ordinal] ?: -1
                )
                ResultItem(
                    title = stringResource(id = R.string.type_CoW),
                    smallItem = true,
                    result = result[Operations.RemovingEndCoW.ordinal] ?: -1
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
fun CollectionResultPreview() {
    CollectionResult(onBackClick = {})
}