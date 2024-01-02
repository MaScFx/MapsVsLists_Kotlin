package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import com.example.foxminded_mapsvslists_kotlin.model.constants.Operations
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AddingEndTest {
    private val testList = ArrayList<Int>()
    private lateinit var addingEnd: AddingEnd

    @Before
    fun setUp() {
        addingEnd = AddingEnd(testList, Operations.AddingEndAL.ordinal)
    }

    @Test
    fun getTestList() {
        Assert.assertEquals(6, addingEnd.getIDOperation())
    }
}