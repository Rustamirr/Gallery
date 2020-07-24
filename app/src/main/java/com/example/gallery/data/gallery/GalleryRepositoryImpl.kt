package com.example.gallery.data.gallery

import com.example.gallery.data.gallery.network.GalleryNetworkSource
import com.example.gallery.data.gallery.network.toPhotoInfoList
import com.example.gallery.domain.gallery.GalleryRepository
import com.example.gallery.domain.gallery.PhotoInfo
import io.reactivex.Single
import javax.inject.Inject

class GalleryRepositoryImpl
@Inject constructor(
    private val galleryNetworkSource: GalleryNetworkSource
) : GalleryRepository {

    override fun searchPhotosByText(page: Int, searchText: String): Single<List<PhotoInfo>> =
        galleryNetworkSource.searchPhotosByText(page, searchText)
            .map { it.toPhotoInfoList() }
}