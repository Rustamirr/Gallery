package com.example.gallery.domain.gallery

data class GalleryState(
    val isSearchTextFilled: Boolean = false,
    val photoInfoList: List<PhotoInfo> = emptyList()
)