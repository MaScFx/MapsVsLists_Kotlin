package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection

import com.example.foxminded_mapsvslists_kotlin.model.constants.Operations
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AddingMiddleTest {

    private val testList = ArrayList<Int>()
    private lateinit var addingMiddle: AddingMiddle

    @Before
    fun setUp() {
        addingMiddle = AddingMiddle(testList, Operations.AddingMiddleAL.ordinal)
    }

    @Test
    fun getTestList() {
        Assert.assertEquals(3, addingMiddle.getIDOperation())
    }
}