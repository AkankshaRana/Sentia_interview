package com.example.sentia.network

import com.example.sentia.network.responses.PropertyServiceResponse
import retrofit2.http.GET

interface PropertyService {

    @GET(".")
    suspend fun get(): PropertyServiceResponse
}