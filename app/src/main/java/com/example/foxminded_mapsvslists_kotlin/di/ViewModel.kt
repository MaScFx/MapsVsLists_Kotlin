package com.example.foxminded_mapsvslists_kotlin.di

import com.example.foxminded_mapsvslists_kotlin.data.repository.CollectionsOperationsRunner
import com.example.foxminded_mapsvslists_kotlin.data.repository.MapsOperationsRunner
import com.example.foxminded_mapsvslists_kotlin.ui.collection.CollectionViewModel
import com.example.foxminded_mapsvslists_kotlin.ui.maps.MapViewModel
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
    fun collectionViewModelProvider(collectionsOR: CollectionsOperationsRunner): CollectionViewModel {
        return CollectionViewModel(collectionsOR)
    }

    @Provides
    @Singleton
    fun mapsViewModelProvider(mapsOR: MapsOperationsRunner): MapViewModel {
        return MapViewModel(mapsOR)
    }

}