package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import android.util.Log

class AddingBeginning(val testList: MutableList<Int>, testID: Int) : BaseListOperationClass(
    testID
) {
    override fun runTask() {
        testList.add(0, 0)
        Log.d("Operation", "AddingBeginning: " + testList[0])
    }
}