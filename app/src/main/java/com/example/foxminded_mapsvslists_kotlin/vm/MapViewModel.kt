package com.example.foxminded_mapsvslists_kotlin.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.foxminded_mapsvslists_kotlin.model.IOperationsRunner
import com.example.foxminded_mapsvslists_kotlin.model.MapsOperationsRunner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MapViewModel(
    private val runner: IOperationsRunner
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun calculate(count: Int) {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    waitingForUserInput = false,
                    calculation = true,
                    defaultInputCount = count
                )

            }
            runner.init(count)
            val hm = HashMap<Int, Int>()
            runner.runTests().collect {
                hm.putAll(it)
            }
            _uiState.update { currentState ->
                currentState.copy(
                    result = hm
                )

            }
            _uiState.update { currentState ->
                currentState.copy(
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
//                MapViewModel(runner = OperationRepository(MapsOperationsRunner()))
                MapViewModel(runner = MapsOperationsRunner())

            }
        }
    }

}