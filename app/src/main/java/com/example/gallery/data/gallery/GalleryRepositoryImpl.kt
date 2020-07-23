package com.example.gallery.data.gallery

import com.example.gallery.data.gallery.network.GalleryNetworkSource
import com.example.gallery.domain.gallery.GalleryDto
import com.example.gallery.domain.gallery.GalleryRepository
import io.reactivex.Single
import javax.inject.Inject

class GalleryRepositoryImpl
@Inject constructor(
    private val galleryNetworkSource: GalleryNetworkSource
) : GalleryRepository {

    override fun getGalleryImages(imageTag: String): Single<GalleryDto> =
        galleryNetworkSource.getGalleryImages(imageTag)
            .map { TODO("Map response to dto") }
}