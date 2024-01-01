package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import android.util.Log

class RemovingMiddle(private val testList: MutableList<Int>, testID: Int) :
    BaseListOperationClass(testList, testID) {
    override fun runTask() {
        val result = testList.removeAt(testList.size / 2)
        Log.d("Operation", "RemovingMiddle: $result")
    }
}