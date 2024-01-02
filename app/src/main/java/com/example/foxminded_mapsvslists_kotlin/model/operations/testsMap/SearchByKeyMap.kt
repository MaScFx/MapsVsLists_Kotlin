package com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap

class SearchByKeyMap(private val testMap: MutableMap<Int, Int>, testID: Int) :
    BaseMapOperation(testID) {
    override suspend fun runTask() {
        val size: Int? = testMap[testMap.size / 2]
    }
}