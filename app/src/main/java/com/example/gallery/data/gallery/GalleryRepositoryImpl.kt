package com.example.gallery.data.gallery

import com.example.gallery.data.gallery.network.GalleryNetworkSource
import com.example.gallery.domain.GalleryRepository
import javax.inject.Inject

class GalleryRepositoryImpl
@Inject constructor(
    private val networkSource: GalleryNetworkSource
) : GalleryRepository {

    override fun loadPhotosInfo(searchText: String, page: Int) =
        networkSource.searchPhotos(searchText, page)

    override fun loadPhotosInfoGeo(searchText: String, page: Int) =
        networkSource.searchPhotosGeo(searchText, page)
}