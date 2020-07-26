package com.example.gallery.data.gallery

import com.example.gallery.data.gallery.network.*
import com.example.gallery.domain.GalleryRepository
import com.example.gallery.domain.PhotoLocation
import com.example.gallery.domain.PhotosInfo
import io.reactivex.Single
import javax.inject.Inject

class GalleryRepositoryImpl
@Inject constructor(
    private val networkSource: GalleryNetworkSource
) : GalleryRepository {

    override fun searchPhotos(
        page: Int,
        pageSize: Int,
        searchText: String
    ): Single<PhotosInfo> =
        networkSource.searchPhotos(page, pageSize, searchText)
            .map(SearchPhotosResponse::toPhotosInfo)

    override fun getPhotoLocation(photoId: String): Single<PhotoLocation> =
        networkSource.getPhotoLocation(photoId)
            .map(GetPhotoLocationResponse::toPhotoLocation)
}