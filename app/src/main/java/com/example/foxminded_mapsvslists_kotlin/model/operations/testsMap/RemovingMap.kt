package com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap

import android.util.Log

class RemovingMap(private val testMap: MutableMap<Int, Int>, testID: Int) :
    BaseMapOperation(testID) {
    override suspend fun runTask() {
        Log.d("Operation", ("RemovingMap: " + testMap.remove(0)))
    }

}