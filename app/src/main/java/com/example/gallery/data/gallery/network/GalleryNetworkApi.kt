package com.example.gallery.data.gallery.network

import io.reactivex.Single

interface GalleryNetworkApi {

    fun getGalleryImages(): Single<GalleryNetworkResponse>
}