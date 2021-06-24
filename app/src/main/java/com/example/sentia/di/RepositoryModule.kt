package com.example.sentia.di

import com.example.sentia.network.PropertyService
import com.example.sentia.network.model.PropertyDTOMapper
import com.example.sentia.repository.PropertyRepository
import com.example.sentia.repository.PropertyRepository_impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePropertyRepository(propertyService: PropertyService
                                  ,propertyDTOMapper: PropertyDTOMapper
    ): PropertyRepository{
        return PropertyRepository_impl(
            propertyService = propertyService,
            mapper = propertyDTOMapper
        )
    }
}