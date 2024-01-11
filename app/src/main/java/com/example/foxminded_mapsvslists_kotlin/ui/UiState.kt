package com.example.foxminded_mapsvslists_kotlin.ui

data class UiState(
    val result: Map<Int, Int> = HashMap(),
    val waitingForUserInput: Boolean = true,
    val calculation: Boolean = false,
    val inputCount: Int =0
)