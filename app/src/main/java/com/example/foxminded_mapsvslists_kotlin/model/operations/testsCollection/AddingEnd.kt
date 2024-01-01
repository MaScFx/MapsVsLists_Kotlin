package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import android.util.Log

class AddingEnd(private val testList: MutableList<Int>, testID: Int) :
    BaseListOperationClass(testID) {
    override fun runTask() {
        testList.add(0)
        Log.d("Operation", "AddingEnd: ${testList[testList.size - 1]} listSize:${testList.size}")
    }
}