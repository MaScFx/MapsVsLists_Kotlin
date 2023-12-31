package com.example.foxminded_mapsvslists_kotlin.vm

data class UiState(
    val result: Map<Int, Int> = HashMap(),
    val waitingForUserInput: Boolean = true,
    val calculation: Boolean = false,
    val defaultInputCount: Int =500000
)