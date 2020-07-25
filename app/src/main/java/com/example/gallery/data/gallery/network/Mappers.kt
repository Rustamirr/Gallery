package com.example.gallery.data.gallery.network

import com.example.gallery.domain.gallery.PhotoInfo
import com.example.gallery.domain.gallery.PhotosInfo

private const val PHOTO_URL_FORMAT = "https://farm%s.staticflickr.com/%s/%s_%s.jpg"

fun SearchPhotosResponse.toPhotosInfo() = PhotosInfo(
    photosResponse.pages, photosResponse.photoResponse
        .map(PhotoResponse::toPhotoInfo)
)

private fun PhotoResponse.toPhotoInfo() = PhotoInfo(
    id, title, PHOTO_URL_FORMAT.format(farmId, serverId, id, secret)
)