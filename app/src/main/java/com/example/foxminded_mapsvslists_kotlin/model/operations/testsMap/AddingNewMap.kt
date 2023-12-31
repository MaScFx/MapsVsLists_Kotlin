package com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap

import android.util.Log
import kotlinx.coroutines.delay

class AddingNewMap(private val testMap: MutableMap<Int, Int>, private val testID: Int) :
    BaseMapOperation(testMap, testID) {
    override suspend fun runTask() {
        val size: Int = testMap.size
        testMap[size + 1] = size + 1
        delay(5)
        Log.d("Operation", "AddingNewMap: " + testMap[size + 1])
    }
}