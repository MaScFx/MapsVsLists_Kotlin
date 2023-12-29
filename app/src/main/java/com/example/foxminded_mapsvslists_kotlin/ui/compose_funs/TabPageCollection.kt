package com.example.foxminded_mapsvslists_kotlin.ui.compose_funs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.vm.CollectionViewModel
import com.example.foxminded_mapsvslists_kotlin.vm.UiState

@Composable
fun TabPageCollection() {
    val collectionViewModel: CollectionViewModel = viewModel(factory = CollectionViewModel.Factory)
    val collectionUiState = collectionViewModel.uiState

    when (collectionUiState) {
        UiState.Calculation -> ResultItem()
        is UiState.Result -> ResultItem()
        UiState.WaitingForUserInput -> EnterSizeScreen(
            title = stringResource(id = R.string.collection_title),
            textFieldValue = stringResource(id = R.string.tf_enter_value),
            onClickButton = { collectionViewModel.calculate(it) }
        )
    }

}