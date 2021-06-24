package com.example.sentia.repository

import com.example.sentia.Properties

interface PropertyRepository {

    suspend fun get(): List<Properties>
}