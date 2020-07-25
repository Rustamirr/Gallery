package com.example.gallery.data.gallery.network

import javax.inject.Inject

private const val API_KEY = "9905f5d6a51f154d5850cd6e9ea0af93"

class GalleryNetworkSourceImpl
@Inject constructor(
    private val galleryNetworkApi: GalleryNetworkApi
) : GalleryNetworkSource {

    override fun searchPhotosByText(page: Int, pageSize: Int, searchText: String) =
        galleryNetworkApi.searchPhotosByText(API_KEY, page, pageSize, searchText)
}