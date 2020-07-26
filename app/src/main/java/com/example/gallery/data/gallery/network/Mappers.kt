package com.example.gallery.data.gallery.network

import com.example.gallery.domain.PhotoInfo
import com.example.gallery.domain.PhotoLocation
import com.example.gallery.domain.PhotosInfo

private const val PHOTO_URL_FORMAT = "https://farm%s.staticflickr.com/%s/%s_%s.jpg"

fun SearchPhotosResponse.toPhotosInfo() = PhotosInfo(
    photosResponse.pages, photosResponse.photoResponse
        .map(PhotoResponse::toPhotoInfo)
)

fun GetPhotoLocationResponse.toPhotoLocation() = photoLocationResponse.run {
    PhotoLocation(id, locationResponse.latitude, locationResponse.longitude)
}

private fun PhotoResponse.toPhotoInfo() = PhotoInfo(
    id, title, PHOTO_URL_FORMAT.format(farmId, serverId, id, secret), null, null
)