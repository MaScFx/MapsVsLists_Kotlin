package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import com.example.foxminded_mapsvslists_kotlin.model.constants.Operations
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RemovingBeginningTest {

    private val testList = ArrayList<Int>()
    private lateinit var removingBeginning: RemovingBeginning

    @Before
    fun setUp() {
        removingBeginning = RemovingBeginning(testList, Operations.RemovingBeginningAL.ordinal)
    }

    @Test
    fun getTestList() {
        assertEquals(12, removingBeginning.getIDOperation())
    }
}