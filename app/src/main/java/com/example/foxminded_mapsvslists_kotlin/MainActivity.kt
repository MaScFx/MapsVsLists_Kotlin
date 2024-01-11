package com.example.foxminded_mapsvslists_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.foxminded_mapsvslists_kotlin.ui.MainTabLayout
import com.example.foxminded_mapsvslists_kotlin.ui.collection.CollectionViewModel
import com.example.foxminded_mapsvslists_kotlin.ui.maps.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val collectionVM: CollectionViewModel by viewModels()
        val mapVM: MapViewModel by viewModels()
        setContent {
            MainTabLayout(collectionVM, mapVM)
        }
    }
}