package com.example.foxminded_mapsvslists_kotlin.ui.collection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.ui.EnterSizeScreen

@Composable
fun TabPageCollection(collectionViewModel: CollectionViewModel) {

    val collectionUiState by collectionViewModel.uiState.collectAsState()

    when (collectionUiState.waitingForUserInput) {
        true -> EnterSizeScreen(
            title = stringResource(id = R.string.collection_title),
            textFieldValue = stringResource(id = R.string.tf_enter_value),
            onClickButton = { collectionViewModel.calculate(it.toInt()) },
            numberInTextField = collectionUiState.inputCount,
            onChangeInputCount = { collectionViewModel.changeInputCount(it) }
        )

        false -> if (collectionUiState.calculation) CollectionResult(
            onBackClick = { collectionViewModel.backToInputScreen() },
        )
        else CollectionResult(
            onBackClick = { collectionViewModel.backToInputScreen() },
            result = collectionUiState.result
        )
    }

}