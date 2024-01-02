package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import com.example.foxminded_mapsvslists_kotlin.model.constants.Operations
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RemovingEndTest {

    private val testList = ArrayList<Int>()
    private lateinit var removingEnd: RemovingEnd

    @Before
    fun setUp() {
        removingEnd = RemovingEnd(testList, Operations.RemovingEndAL.ordinal)
    }

    @Test
    fun getTestList() {
        Assert.assertEquals(18, removingEnd.getIDOperation())
    }
}