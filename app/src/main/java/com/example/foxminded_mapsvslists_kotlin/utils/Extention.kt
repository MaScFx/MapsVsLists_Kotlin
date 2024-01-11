package com.example.foxminded_mapsvslists_kotlin.utils

fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
}