package com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap

import android.util.Log

class AddingNewMap(private val testMap: MutableMap<Int, Int>, testID: Int) :
    BaseMapOperation(testID) {
    override suspend fun runTask() {
        val size: Int = testMap.size
        testMap[size + 1] = size + 1
        Log.d("Operation", "AddingNewMap: " + testMap[size + 1])
    }
}