package com.example.gallery.data.gallery.network

import com.example.gallery.domain.PhotoInfo
import io.reactivex.Single

interface GalleryNetworkSource {

    fun searchPhotos(searchText: String, page: Int): Single<List<PhotoInfo>>

    fun searchPhotosGeo(searchText: String, page: Int): Single<List<PhotoInfo>>
}