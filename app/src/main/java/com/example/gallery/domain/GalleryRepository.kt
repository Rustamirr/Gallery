package com.example.gallery.domain

import io.reactivex.Single

interface GalleryRepository {

    fun loadPhotosInfo(searchText: String, page: Int): Single<List<PhotoInfo>>

    fun loadPhotosInfoGeo(searchText: String, page: Int): Single<List<PhotoInfo>>
}