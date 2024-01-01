package com.example.foxminded_mapsvslists_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.MainTabLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTabLayout()
        }
    }
}