package com.example.foxminded_mapsvslists_kotlin.model.operations

import android.util.Pair
import kotlinx.coroutines.flow.Flow


interface IOperation {
    fun runTest():Flow<Pair<Int, Int>>
    fun getIDOperation(): Int
}
