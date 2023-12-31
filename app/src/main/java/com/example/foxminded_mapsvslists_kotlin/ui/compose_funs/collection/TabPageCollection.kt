package com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.collection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.EnterSizeScreen
import com.example.foxminded_mapsvslists_kotlin.vm.CollectionViewModel

@Composable
fun TabPageCollection(collectionViewModel: CollectionViewModel = viewModel(factory = CollectionViewModel.Factory)) {

    val collectionUiState by collectionViewModel.uiState.collectAsState()

    when (collectionUiState.waitingForUserInput) {
        true -> EnterSizeScreen(
            title = stringResource(id = R.string.collection_title),
            textFieldValue = stringResource(id = R.string.tf_enter_value),
            onClickButton = { collectionViewModel.calculate(it) },
            numberInTextFieldField = collectionUiState.inputNumber
        )

        false -> if (collectionUiState.calculation)
            CollectionResult(
                onBackClick = { collectionViewModel.backToInputScreen() },
                resultIsReady = false
            )
        else
            CollectionResult(
                onBackClick = { collectionViewModel.backToInputScreen() },
                resultIsReady = true,
                result = collectionUiState.result
            )
    }

}