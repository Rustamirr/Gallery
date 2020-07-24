package com.example.gallery.presentation.gallery.adapter

data class PhotoItem(
    val id: String,
    val title: String,
    val farmId: Int,
    val secret: String,
    val serverId: String
)