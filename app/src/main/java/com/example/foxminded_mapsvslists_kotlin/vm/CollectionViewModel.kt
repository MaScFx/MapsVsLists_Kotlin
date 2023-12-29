package com.example.foxminded_mapsvslists_kotlin.vm


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.foxminded_mapsvslists_kotlin.data.IOperationRepository
import com.example.foxminded_mapsvslists_kotlin.data.OperationRepository
import com.example.foxminded_mapsvslists_kotlin.model.OperationRunner
import kotlinx.coroutines.launch


class CollectionViewModel(
    private val runner: IOperationRepository
) : ViewModel() {

    var uiState: UiState by mutableStateOf(UiState.WaitingForUserInput)
        private set

    fun calculate(count: Int) {
        viewModelScope.launch {
            uiState = UiState.Calculation
        }
    }

    fun backToInputScreen() {
        viewModelScope.launch {
            uiState = UiState.WaitingForUserInput
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CollectionViewModel(runner = OperationRepository(OperationRunner()))
            }
        }
    }

}