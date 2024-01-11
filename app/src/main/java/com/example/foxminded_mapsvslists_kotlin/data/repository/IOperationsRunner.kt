package com.example.foxminded_mapsvslists_kotlin.data.repository

import kotlinx.coroutines.flow.Flow

interface IOperationsRunner {
    suspend fun init(collectionSize: Int)

    suspend fun runTests(): Flow<HashMap<Int, Int>>
}