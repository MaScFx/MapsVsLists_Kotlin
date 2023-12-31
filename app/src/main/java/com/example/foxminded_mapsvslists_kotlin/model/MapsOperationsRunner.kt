package com.example.foxminded_mapsvslists_kotlin.model

import com.example.foxminded_mapsvslists_kotlin.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.model.operations.IOperation
import com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap.AddingNewMap
import com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap.RemovingMap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.TreeMap

class MapsOperationsRunner : IOperationsRunner {
    var hashMap = HashMap<Int, Int>()
    var treeMap = TreeMap<Int, Int>()
    val results = HashMap<Int, Int>()

    override suspend fun init(collectionSize: Int) {
        for (i in 0..collectionSize) {
            hashMap[i] = i
            treeMap[i] = i
        }
    }

    override suspend fun runTests(): Flow<HashMap<Int, Int>> = flow {

        initTests().forEach {
            it.runTest().collect { pair ->
                results[pair.first] = pair.second
            }
        }
        emit(results)
    }

    private fun initTests(): ArrayList<IOperation> {
        val testsLists = ArrayList<IOperation>()
        testsLists.add(AddingNewMap(hashMap, Operations.AddingNewHM.ordinal))
        testsLists.add(AddingNewMap(treeMap, Operations.AddingNewTM.ordinal))
        testsLists.add(RemovingMap(hashMap, Operations.RemovingHM.ordinal))
        testsLists.add(RemovingMap(treeMap, Operations.RemovingTM.ordinal))
        testsLists.add(AddingNewMap(hashMap, Operations.SearchHM.ordinal))
        testsLists.add(AddingNewMap(treeMap, Operations.SearchTM.ordinal))

        return testsLists
    }
}