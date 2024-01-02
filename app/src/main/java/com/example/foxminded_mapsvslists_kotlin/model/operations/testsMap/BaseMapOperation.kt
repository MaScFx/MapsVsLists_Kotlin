package com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap

import android.util.Pair
import com.example.foxminded_mapsvslists_kotlin.model.operations.IOperation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseMapOperation(
    private val testID: Int
) : IOperation {

    override fun getIDOperation(): Int {
        return testID
    }

    protected abstract suspend fun runTask()
    override fun runTest(): Flow<Pair<Int, Int>> = flow {
        val startTime = System.currentTimeMillis()
        runTask()
        val finalTime = System.currentTimeMillis() - startTime

        emit(Pair<Int, Int>(getIDOperation(), finalTime.toInt()))
    }
}