package com.example.foxminded_mapsvslists_kotlin.vm

sealed class UiState {
    data class Result(val result: Map<Int, Int>) : UiState()
    object WaitingForUserInput : UiState()
    object Calculation : UiState()
}