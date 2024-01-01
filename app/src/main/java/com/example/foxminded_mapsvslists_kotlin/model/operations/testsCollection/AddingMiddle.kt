package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import android.util.Log

class AddingMiddle(private val testList: MutableList<Int>, testID: Int) :
    BaseListOperationClass(testID) {
    override fun runTask() {
        val index = testList.size / 2
        testList.add(index, 0)
        Log.d("Operation", "AddingMiddle: ${testList[index]} listSize:${testList.size}")
    }
}