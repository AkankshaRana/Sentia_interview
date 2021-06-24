package com.example.sentia.repository

import com.example.sentia.Properties
import com.example.sentia.network.PropertyService
import com.example.sentia.network.model.PropertyDTOMapper

class PropertyRepository_impl(
    private val propertyService: PropertyService,
    private val mapper: PropertyDTOMapper
): PropertyRepository {

    override suspend fun get(): List<Properties> {
        return mapper.toDomainList(propertyService.get().properties)
    }
}