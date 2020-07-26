package com.example.gallery.domain

import io.reactivex.Single

interface GalleryRepository {

    fun searchPhotos(page: Int, pageSize: Int, searchText: String): Single<PhotosInfo>

    fun getPhotoLocation(photoId: String): Single<PhotoLocation>
}