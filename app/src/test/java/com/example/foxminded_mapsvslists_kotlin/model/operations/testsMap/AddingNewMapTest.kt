package com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap

import com.example.foxminded_mapsvslists_kotlin.data.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsMap.AddingNewMap
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class AddingNewMapTest {
    private val testMap = HashMap<Int, Int>()
    private lateinit var addingNewMap: AddingNewMap

    @Before
    fun setUp() {
        addingNewMap = AddingNewMap(testMap,Operations.AddingNewHM.ordinal)
    }

    @Test
    fun getIDOperation() {
        assertEquals(21,addingNewMap.getIDOperation() )
    }
}