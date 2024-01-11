package com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsMap

class RemovingMap(private val testMap: MutableMap<Int, Int>, testID: Int) :
    BaseMapOperation(testID) {
    override suspend fun runTask() {
        testMap.remove(0)
    }

}