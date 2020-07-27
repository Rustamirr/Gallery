package com.example.gallery.domain

data class PhotoInfo(
    val id: String,
    val title: String,
    val url: String,
    val latitude: Double?,
    val longitude: Double?
)