package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import com.example.foxminded_mapsvslists_kotlin.data.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsCollection.RemovingMiddle
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RemovingMiddleTest {

    private val testList = ArrayList<Int>()
    private lateinit var removingMiddle: RemovingMiddle

    @Before
    fun setUp() {
        removingMiddle = RemovingMiddle(testList, Operations.AddingMiddleAL.ordinal)
    }

    @Test
    fun getTestList() {
        assertEquals(3, removingMiddle.getIDOperation())
    }
}