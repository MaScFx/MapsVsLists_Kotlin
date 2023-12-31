package com.example.foxminded_mapsvslists_kotlin.model

import kotlinx.coroutines.flow.Flow

interface IOperationsRunner {
    suspend fun init(collectionSize: Int)

    suspend fun runTests(): Flow<HashMap<Int, Int>>
}