package com.example.gallery.data.gallery.network

import com.example.gallery.domain.gallery.PhotoInfo
import com.example.gallery.domain.gallery.PhotosInfo

fun SearchPhotosResponse.toPhotosInfo() = PhotosInfo(
    photosResponse.pages, photosResponse.photoResponse
        .map(PhotoResponse::toPhotoInfo)
)

private fun PhotoResponse.toPhotoInfo() = PhotoInfo(id, title, farmId, secret, serverId)