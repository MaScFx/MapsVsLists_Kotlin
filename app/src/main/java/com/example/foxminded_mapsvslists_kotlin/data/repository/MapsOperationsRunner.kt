package com.example.foxminded_mapsvslists_kotlin.data.repository

import android.util.Log
import com.example.foxminded_mapsvslists_kotlin.data.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.IOperation
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsMap.AddingNewMap
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsMap.RemovingMap
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsMap.SearchByKeyMap
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.TreeMap
import javax.inject.Inject

class MapsOperationsRunner @Inject constructor() : IOperationsRunner {
    private var hashMap = HashMap<Int, Int>()
    private var treeMap = TreeMap<Int, Int>()
    private val results = HashMap<Int, Int>()

    override suspend fun init(collectionSize: Int) {
        Log.d("Operation", "startInitMap: count $collectionSize")
        for (i in 0 until collectionSize) {
            hashMap[i] = i
            treeMap[i] = i
        }
        Log.d("Operation", "endInitMap: count HM: ${hashMap.size}, TM: ${treeMap.size}")

    }

    override suspend fun runTests(): Flow<HashMap<Int, Int>> = flow {
        coroutineScope {
            initTests().forEach {
                it.runTest().collect { pair ->
                    results[pair.first] = pair.second
                }
            }
            emit(results)
        }

    }

    private fun initTests(): ArrayList<IOperation> {
        val testsLists = ArrayList<IOperation>()
        testsLists.add(AddingNewMap(hashMap, Operations.AddingNewHM.ordinal))
        testsLists.add(AddingNewMap(treeMap, Operations.AddingNewTM.ordinal))
        testsLists.add(RemovingMap(hashMap, Operations.RemovingHM.ordinal))
        testsLists.add(RemovingMap(treeMap, Operations.RemovingTM.ordinal))
        testsLists.add(SearchByKeyMap(hashMap, Operations.SearchHM.ordinal))
        testsLists.add(SearchByKeyMap(treeMap, Operations.SearchTM.ordinal))

        return testsLists
    }
}