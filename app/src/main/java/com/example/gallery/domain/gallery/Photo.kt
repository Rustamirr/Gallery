package com.example.gallery.domain.gallery

data class Photo(
    val id: String,
    val title: String,
    val farmId: Int,
    val secret: String,
    val serverId: String
)