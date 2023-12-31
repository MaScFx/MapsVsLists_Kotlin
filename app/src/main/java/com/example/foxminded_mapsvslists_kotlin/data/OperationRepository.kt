package com.example.foxminded_mapsvslists_kotlin.data

import com.example.foxminded_mapsvslists_kotlin.model.MapsOperationsRunner
import kotlinx.coroutines.delay

interface IOperationRepository {
    suspend fun calculateTests(count: Int): Map<Int, Int>
}

class OperationRepository(val operationsRunner: MapsOperationsRunner) : IOperationRepository {
    override suspend fun calculateTests(count: Int): Map<Int, Int> {
        val result: HashMap<Int, Int> = HashMap()
        delay(1300)
        for (i in 0..40) {
            result[i] = i
        }

        return result
    }

}
