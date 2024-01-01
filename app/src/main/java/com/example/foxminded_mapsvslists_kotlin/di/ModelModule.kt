//package com.example.foxminded_mapsvslists_kotlin.di
//
//import com.example.foxminded_mapsvslists_kotlin.model.CollectionsOperationsRunner
//import com.example.foxminded_mapsvslists_kotlin.model.IOperationsRunner
//import com.example.foxminded_mapsvslists_kotlin.model.MapsOperationsRunner
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ViewModelComponent
//
//
//@Module
//@InstallIn(ViewModelComponent::class)
//class ModelModule {
//
//    @Provides
//    fun collectionsOperationsRunnerProvider():CollectionsOperationsRunner{
//        return CollectionsOperationsRunner()
//    }
//
//    @Provides
//    fun mapsOperationsRunnerProvider():MapsOperationsRunner{
//        return MapsOperationsRunner()
//    }
//}