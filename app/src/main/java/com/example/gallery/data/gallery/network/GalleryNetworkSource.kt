package com.example.gallery.data.gallery.network

import io.reactivex.Single

interface GalleryNetworkSource {

    fun getGalleryImages(imageTag: String): Single<GalleryNetworkResponse>
}