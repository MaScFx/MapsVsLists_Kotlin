package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import com.example.foxminded_mapsvslists_kotlin.data.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsCollection.RemovingEnd
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