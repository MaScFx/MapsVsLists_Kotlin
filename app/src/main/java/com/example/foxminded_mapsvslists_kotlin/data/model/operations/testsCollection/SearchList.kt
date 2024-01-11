package com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsCollection

import android.util.Log

class SearchList(private val testList: MutableList<Int>, testID: Int) :
    BaseListOperationClass(testID) {
    override fun runTask() {
        val result = testList.indexOf(testList.size)
        Log.d(
            "Operation", "SearchList: index is $result ListSize:${testList.size}"
        )
    }
}