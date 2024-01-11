package com.example.foxminded_mapsvslists_kotlin.ui.maps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.ui.EnterSizeScreen

@Composable
fun TabPageMap(mapViewModel: MapViewModel) {

    val mapUiState by mapViewModel.uiState.collectAsState()

    when (mapUiState.waitingForUserInput) {
        true -> EnterSizeScreen(
            title = stringResource(id = R.string.map_title),
            textFieldValue = stringResource(id = R.string.tf_enter_value),
            onClickButton = { mapViewModel.calculate(it.toInt()) },
            numberInTextField = mapUiState.inputCount,
            onChangeInputCount = {mapViewModel.changeInputCount(it)}
        )

        false -> if (mapUiState.calculation) MapResult(
            onBackClick = { mapViewModel.backToInputScreen() },
        ) else MapResult(
            onBackClick = { mapViewModel.backToInputScreen() }, result = mapUiState.result
        )
    }
}