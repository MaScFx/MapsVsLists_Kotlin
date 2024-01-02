package com.example.foxminded_mapsvslists_kotlin.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foxminded_mapsvslists_kotlin.model.IOperationsRunner
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val runner: IOperationsRunner
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun calculate(count: Int) {
        viewModelScope.launch(Dispatchers.Default) {

            _uiState.update { currentState ->
                currentState.copy(
                    waitingForUserInput = false, calculation = true, defaultInputCount = count
                )
            }
            runner.init(count)
            val hm = HashMap<Int, Int>()
            runner.runTests().collect {
                hm.putAll(it)
            }
            _uiState.update { currentState ->
                currentState.copy(
                    result = hm, calculation = false
                )
            }
        }
    }

    fun backToInputScreen() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    waitingForUserInput = true, calculation = false
                )
            }
        }
    }
}