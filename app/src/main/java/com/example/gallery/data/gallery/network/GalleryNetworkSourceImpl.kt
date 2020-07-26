package com.example.gallery.data.gallery.network

import io.reactivex.Single
import javax.inject.Inject

private const val API_KEY = "9905f5d6a51f154d5850cd6e9ea0af93"

class GalleryNetworkSourceImpl
@Inject constructor(
    private val networkApi: GalleryNetworkApi
) : GalleryNetworkSource {

    override fun searchPhotos(page: Int, pageSize: Int, searchText: String) =
        networkApi.searchPhotos(API_KEY, page, pageSize, searchText)

    override fun getPhotoLocation(photoId: String): Single<GetPhotoLocationResponse> =
        networkApi.getPhotoLocation(API_KEY, photoId)
}