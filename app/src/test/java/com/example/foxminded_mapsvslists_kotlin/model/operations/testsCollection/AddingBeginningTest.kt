package com.example.foxminded_mapsvslists_kotlin.model.operations.testsCollection


import com.example.foxminded_mapsvslists_kotlin.data.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsCollection.AddingBeginning
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class AddingBeginningTest {
    private val testList = ArrayList<Int>()
    private lateinit var addingBeginning: AddingBeginning

    @Before
    fun setUp() {
        addingBeginning = AddingBeginning(testList, Operations.AddingBeginningAL.ordinal)
    }

    @Test
    fun getTestList() {
        Assert.assertEquals(0, addingBeginning.getIDOperation())
    }
}