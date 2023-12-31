package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import android.util.Log
import kotlinx.coroutines.delay

class AddingBeginning(val testList: MutableList<Int>, testID: Int) :BaseListOperationClass(testList,
    testID
) {
    override fun runTask() {
        val size: Int = testList.size
        testList.add(0,0)

        Log.d("Operation", "AddingBeginning: " + testList[0])
    }
}