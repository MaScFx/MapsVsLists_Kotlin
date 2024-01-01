package com.example.foxminded_mapsvslists_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.foxminded_mapsvslists_kotlin.ui.compose_funs.MainTabLayout
import com.example.foxminded_mapsvslists_kotlin.vm.CollectionViewModel
import com.example.foxminded_mapsvslists_kotlin.vm.MapViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Qualifier

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val collectionVM: CollectionViewModel by viewModels()
        val mapVM: MapViewModel by viewModels()
        setContent {
            MainTabLayout(collectionVM,mapVM)
        }
    }
}
//
//interface SomeInterface{
//    fun doJob()
//}
//class Main(private val someClass: SomeInterface ){
//    fun job(){
//        someClass.doJob()
//    }
//}
//
//class SomeInterfaceOneImpl:SomeInterface {
//    override fun doJob() {
//    }
//}
//class SomeInterfaceTwoImpl:SomeInterface {
//    override fun doJob() {
//    }
//}
//
//@Retention(AnnotationRetention.BINARY)
//@Qualifier
//annotation class SomeInterfaceOneImplQualifier
//
//@Retention(AnnotationRetention.BINARY)
//@Qualifier
//annotation class SomeInterfaceTwoImplQualifier
