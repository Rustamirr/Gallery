package com.example.gallery.domain.gallery

import io.reactivex.Single

interface GalleryRepository {

    fun searchPhotosByText(page: Int, searchText: String): Single<List<PhotoInfo>>
}