package com.example.gallery.data.gallery.network

import javax.inject.Inject

class GalleryNetworkSourceImpl
@Inject constructor(
    private val galleryNetworkApi: GalleryNetworkApi
) : GalleryNetworkSource {

    override fun getGalleryImages(imageTag: String) = galleryNetworkApi.getGalleryImages()
}