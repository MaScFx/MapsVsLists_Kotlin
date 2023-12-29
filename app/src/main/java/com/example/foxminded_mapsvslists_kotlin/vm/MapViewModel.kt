package com.example.foxminded_mapsvslists_kotlin.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.foxminded_mapsvslists_kotlin.data.IOperationRepository
import com.example.foxminded_mapsvslists_kotlin.data.OperationRepository
import com.example.foxminded_mapsvslists_kotlin.model.OperationRunner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MapViewModel(
    private val runner: IOperationRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

//        private set

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
                MapViewModel(runner = OperationRepository(OperationRunner()))
            }
        }
    }

}