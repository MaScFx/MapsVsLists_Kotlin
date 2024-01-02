package com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap

import com.example.foxminded_mapsvslists_kotlin.model.constants.Operations
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class SearchByKeyMapTest {

    private val testMap = HashMap<Int, Int>()
    private lateinit var searchByKeyMap: SearchByKeyMap

    @Before
    fun setUp() {
        searchByKeyMap = SearchByKeyMap(testMap, Operations.SearchHM.ordinal)
    }

    @Test
    fun getIDOperation() {
        assertEquals(23,searchByKeyMap.getIDOperation() )
    }
}