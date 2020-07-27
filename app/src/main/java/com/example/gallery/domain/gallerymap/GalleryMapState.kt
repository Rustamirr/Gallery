package com.example.gallery.domain.gallerymap

import com.example.gallery.domain.PhotoInfo

data class GalleryMapState(
    val photoInfo: List<PhotoInfo> = emptyList()
)