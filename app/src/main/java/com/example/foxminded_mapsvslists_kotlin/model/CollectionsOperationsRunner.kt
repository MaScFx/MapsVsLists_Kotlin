package com.example.foxminded_mapsvslists_kotlin.model

import kotlinx.coroutines.flow.Flow
import java.util.LinkedList
import java.util.concurrent.CopyOnWriteArrayList

class CollectionsOperationsRunner : IOperationsRunner {
    var arrayList: ArrayList<Int>? = null
    var linkedList: LinkedList<Int>? = null
    var copyOnWrite: CopyOnWriteArrayList<Int>? = null
    val results = HashMap<Int, Int>()

    override suspend fun init(collectionSize: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun runTests(): Flow<HashMap<Int, Int>> {
        TODO("Not yet implemented")
    }
}