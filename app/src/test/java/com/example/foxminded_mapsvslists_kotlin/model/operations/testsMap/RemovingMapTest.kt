package com.example.foxminded_mapsvslists_kotlin.model.operations.testsMap

import com.example.foxminded_mapsvslists_kotlin.data.model.constants.Operations
import com.example.foxminded_mapsvslists_kotlin.data.model.operations.testsMap.RemovingMap
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RemovingMapTest {

    private val testMap = HashMap<Int, Int>()
    private lateinit var removingMap: RemovingMap

    @Before
    fun setUp() {
        removingMap = RemovingMap(testMap, Operations.RemovingHM.ordinal)
    }

    @Test
    fun getIDOperation() {
        Assert.assertEquals(25, removingMap.getIDOperation())
    }
}