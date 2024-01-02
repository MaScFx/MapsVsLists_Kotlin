package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

class AddingBeginning(val testList: MutableList<Int>, testID: Int) : BaseListOperationClass(
    testID
) {
    override fun runTask() {
        testList.add(0, 0)
    }
}