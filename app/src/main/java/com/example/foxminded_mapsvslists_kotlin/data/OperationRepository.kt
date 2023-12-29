package com.example.foxminded_mapsvslists_kotlin.data

import com.example.foxminded_mapsvslists_kotlin.model.OperationRunner
import com.example.foxminded_mapsvslists_kotlin.model.constants.Operations

interface IOperationRepository {
    suspend fun calculateTests(count: Int):Map<Int, Int>
}
class OperationRepository(val operationsRunner: OperationRunner):IOperationRepository{
    override suspend fun calculateTests(count: Int): Map<Int, Int> {
        val result: HashMap<Int, Int> = HashMap()
        for (i in 0..40){
            result[i]=i
        }

        return result
        TODO("Not yet implemented")
    }

}
