package com.example.gallery.domain.gallery

data class PhotosInfo(
    val pages: Int,
    val photoInfo: List<PhotoInfo>
)

data class PhotoInfo(
    val id: String,
    val title: String,
    val farmId: Int,
    val secret: String,
    val serverId: String
)