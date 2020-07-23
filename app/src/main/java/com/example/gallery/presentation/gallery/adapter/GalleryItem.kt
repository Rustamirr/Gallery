package com.example.gallery.presentation.gallery.adapter

data class GalleryItem(
    val id: String,
    val title: String,
    val farmId: Int,
    val secret: String,
    val serverId: String
)