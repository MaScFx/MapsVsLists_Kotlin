package com.example.foxminded_mapsvslists_kotlin.vm


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.foxminded_mapsvslists_kotlin.data.IOperationRepository
import com.example.foxminded_mapsvslists_kotlin.data.OperationRepository
import com.example.foxminded_mapsvslists_kotlin.model.MapsOperationsRunner
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext


class CollectionViewModel(
    private val runner: IOperationRepository
) : ViewModel() {


    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()


    @OptIn(DelicateCoroutinesApi::class)
    fun calculate(count: Int) {
        viewModelScope.launch(newSingleThreadContext("Counter")) {

            _uiState.update { currentState ->
                currentState.copy(
                    waitingForUserInput = false,
                    calculation = true,
                )
            }
            _uiState.update { currentState ->
                currentState.copy(
                    result = runner.calculateTests(count),
                    calculation = false
                )

            }
        }
    }

    fun backToInputScreen() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    waitingForUserInput = true,
                    calculation = false
                )
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CollectionViewModel(runner = OperationRepository(MapsOperationsRunner()))
            }
        }
    }

}