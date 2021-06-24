package com.example.sentia.network.responses

import com.example.sentia.network.model.PropertyDTO
import com.google.gson.annotations.SerializedName

data class PropertyServiceResponse(

    @SerializedName(value = "data")
    var properties: List<PropertyDTO>,
)