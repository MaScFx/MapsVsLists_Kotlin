package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import android.util.Log

class RemovingEnd(private val testList: MutableList<Int>, testID: Int) :
    BaseListOperationClass(testID) {
    override fun runTask() {
        val result = testList.removeAt(testList.size - 1)
        Log.d("Operation", "RemovingEnd: $result")
    }
}