package com.example.foxminded_mapsvslists_kotlin.model

import com.example.foxminded_mapsvslists_kotlin.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.model.operations.IOperation
import com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection.AddingBeginning
import com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection.AddingEnd
import com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection.AddingMiddle
import com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection.RemovingBeginning
import com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection.RemovingEnd
import com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection.RemovingMiddle
import com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection.SearchList
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.LinkedList
import java.util.concurrent.CopyOnWriteArrayList

class CollectionsOperationsRunner : IOperationsRunner {
    private var arrayList= ArrayList<Int>()
    private var linkedList= LinkedList<Int>()
    private var copyOnWrite= CopyOnWriteArrayList<Int>()
    private val results = HashMap<Int, Int>()

    override suspend fun init(collectionSize: Int) {
        for (i in 1 until collectionSize){
            arrayList.add(i)
        }
        linkedList.addAll(arrayList)
        copyOnWrite.addAll(arrayList)
    }

    override suspend fun runTests(): Flow<HashMap<Int, Int>> = flow{
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

        testsLists.add(AddingBeginning(arrayList,Operations.AddingBeginningAL.ordinal))
        testsLists.add(AddingBeginning(linkedList,Operations.AddingBeginningLL.ordinal))
        testsLists.add(AddingBeginning(copyOnWrite,Operations.AddingBeginningCoW.ordinal))

        testsLists.add(AddingMiddle(arrayList,Operations.AddingMiddleAL.ordinal))
        testsLists.add(AddingMiddle(linkedList,Operations.AddingMiddleLL.ordinal))
        testsLists.add(AddingMiddle(copyOnWrite,Operations.AddingMiddleCoW.ordinal))

        testsLists.add(AddingEnd(arrayList,Operations.AddingEndAL.ordinal))
        testsLists.add(AddingEnd(linkedList,Operations.AddingEndLL.ordinal))
        testsLists.add(AddingEnd(copyOnWrite,Operations.AddingEndCoW.ordinal))

        testsLists.add(SearchList(arrayList,Operations.SearchAL.ordinal))
        testsLists.add(SearchList(linkedList,Operations.SearchLL.ordinal))
        testsLists.add(SearchList(copyOnWrite,Operations.SearchCoW.ordinal))

        testsLists.add(RemovingBeginning(arrayList,Operations.RemovingBeginningAL.ordinal))
        testsLists.add(RemovingBeginning(linkedList,Operations.RemovingBeginningLL.ordinal))
        testsLists.add(RemovingBeginning(copyOnWrite,Operations.RemovingBeginningCoW.ordinal))

        testsLists.add(RemovingMiddle(arrayList,Operations.RemovingMiddleAL.ordinal))
        testsLists.add(RemovingMiddle(linkedList,Operations.RemovingMiddleLL.ordinal))
        testsLists.add(RemovingMiddle(copyOnWrite,Operations.RemovingMiddleCoW.ordinal))

        testsLists.add(RemovingEnd(arrayList,Operations.RemovingEndAL.ordinal))
        testsLists.add(RemovingEnd(linkedList,Operations.RemovingEndLL.ordinal))
        testsLists.add(RemovingEnd(copyOnWrite,Operations.RemovingEndCoW.ordinal))

        return testsLists
    }
}