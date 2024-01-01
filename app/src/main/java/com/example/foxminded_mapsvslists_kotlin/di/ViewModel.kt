package com.example.foxminded_mapsvslists_kotlin.di

import com.example.foxminded_mapsvslists_kotlin.model.CollectionsOperationsRunner
import com.example.foxminded_mapsvslists_kotlin.model.MapsOperationsRunner
import com.example.foxminded_mapsvslists_kotlin.vm.CollectionViewModel
import com.example.foxminded_mapsvslists_kotlin.vm.MapViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModel {

    @Provides
    @Singleton
    fun CollectionViewModelProvider(collectionsOR: CollectionsOperationsRunner): CollectionViewModel {
        return CollectionViewModel(collectionsOR)
    }

    @Provides
    @Singleton
    fun mapsViewModelProvider(mapsOR: MapsOperationsRunner): MapViewModel {
        return MapViewModel(mapsOR)
    }

}