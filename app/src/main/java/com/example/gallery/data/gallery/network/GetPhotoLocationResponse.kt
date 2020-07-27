package com.example.gallery.data.gallery.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetPhotoLocationResponse(
    @Expose
    @SerializedName("photo")
    val photoLocationResponse: PhotoLocationResponse
)

data class PhotoLocationResponse(
    @Expose
    @SerializedName("id")
    val id: String,

    @Expose
    @SerializedName("location")
    val locationResponse: LocationResponse
)

data class LocationResponse(
    @Expose
    @SerializedName("latitude")
    val latitude: String,

    @Expose
    @SerializedName("longitude")
    val longitude: String
)