package com.example.gallery.data.gallery.network

import io.reactivex.Single

interface GalleryNetworkSource {

    fun searchPhotosByText(
        page: Int,
        pageSize: Int,
        searchText: String
    ): Single<SearchPhotosResponse>
}