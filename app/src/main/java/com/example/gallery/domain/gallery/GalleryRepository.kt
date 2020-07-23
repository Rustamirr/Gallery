package com.example.gallery.domain.gallery

import io.reactivex.Single

interface GalleryRepository {

    fun getGalleryImages(imageTag: String): Single<GalleryDto>
}