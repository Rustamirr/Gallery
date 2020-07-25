package com.example.gallery.data.gallery

import com.example.gallery.data.gallery.network.GalleryNetworkSource
import com.example.gallery.data.gallery.network.SearchPhotosResponse
import com.example.gallery.data.gallery.network.toPhotosInfo
import com.example.gallery.domain.gallery.GalleryRepository
import com.example.gallery.domain.gallery.PhotosInfo
import io.reactivex.Single
import javax.inject.Inject

class GalleryRepositoryImpl
@Inject constructor(
    private val galleryNetworkSource: GalleryNetworkSource
) : GalleryRepository {

    override fun searchPhotosByText(
        page: Int,
        pageSize: Int,
        searchText: String
    ): Single<PhotosInfo> =
        galleryNetworkSource.searchPhotosByText(page, pageSize, searchText)
            .map(SearchPhotosResponse::toPhotosInfo)
}