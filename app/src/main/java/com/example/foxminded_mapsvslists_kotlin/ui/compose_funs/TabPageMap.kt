package com.example.foxminded_mapsvslists_kotlin.ui.compose_funs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.vm.MapViewModel
import com.example.foxminded_mapsvslists_kotlin.vm.UiState

@Composable
fun TabPageMap() {
    val mapViewModel: MapViewModel =
        viewModel(factory = MapViewModel.Factory)
    val collectionUiState = mapViewModel.uiState

    when (collectionUiState) {
        UiState.Calculation -> ResultItem()
        is UiState.Result -> ResultItem()
        UiState.WaitingForUserInput -> EnterSizeScreen(
            title = stringResource(id = R.string.map_title),
            textFieldValue = stringResource(id = R.string.tf_enter_value),
            onClickButton = { mapViewModel.calculate(it) })
    }

}