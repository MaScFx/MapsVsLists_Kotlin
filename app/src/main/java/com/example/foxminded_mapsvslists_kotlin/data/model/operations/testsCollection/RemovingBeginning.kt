package com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsCollection

import android.util.Log

class RemovingBeginning(private val testList: MutableList<Int>, testID: Int) :
    BaseListOperationClass(testID) {
    override fun runTask() {
        val result = testList.removeAt(0)
        Log.d("Operation", "RemovingBeginning: $result listSize:${testList.size}")
    }
}