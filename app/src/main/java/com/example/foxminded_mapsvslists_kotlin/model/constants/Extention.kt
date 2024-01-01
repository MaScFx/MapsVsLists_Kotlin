package com.example.foxminded_mapsvslists_kotlin.model.constants

fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
}