package com.example.gallery.domain

data class PhotosInfo(
    val pages: Int,
    val photoInfo: List<PhotoInfo>
)

data class PhotoInfo(
    val id: String,
    val title: String,
    val url: String,
    val latitude: String?,
    val longitude: String?
)

data class PhotoLocation(
    val photoId: String,
    val latitude: String,
    val longitude: String
)