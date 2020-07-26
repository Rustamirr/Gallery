package com.example.gallery.data.gallery.network

import io.reactivex.Single

interface GalleryNetworkSource {

    fun searchPhotos(
        page: Int,
        pageSize: Int,
        searchText: String
    ): Single<SearchPhotosResponse>

    fun getPhotoLocation(photoId: String): Single<GetPhotoLocationResponse>
}