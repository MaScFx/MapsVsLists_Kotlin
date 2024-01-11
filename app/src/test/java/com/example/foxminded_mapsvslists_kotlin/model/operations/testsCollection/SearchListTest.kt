package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import com.example.foxminded_mapsvslists_kotlin.data.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsCollection.SearchList
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class SearchListTest {

    private val testList = ArrayList<Int>()
    private lateinit var searchList: SearchList

    @Before
    fun setUp() {
        searchList = SearchList(testList, Operations.SearchAL.ordinal)
    }

    @Test
    fun getTestList() {
        assertEquals(9, searchList.getIDOperation())
    }
}