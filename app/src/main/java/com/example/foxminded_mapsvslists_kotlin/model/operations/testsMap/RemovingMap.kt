package com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap

import android.util.Log

class RemovingMap(private val testMap: MutableMap<Int, Int>, private val testID: Int) :
    BaseMapOperation(testMap, testID) {
    override suspend fun runTask() {
//        val size: Int = testMap.size
        Log.d("Operation", ("RemovingMap: " + testMap.remove(0)).toString())
    }

}