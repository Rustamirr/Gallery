package com.example.gallery.data.gallery.network

import com.example.gallery.domain.gallery.PhotoInfo

fun SearchPhotosResponse.toPhotoInfoList() = photosResponse.photoResponse
    .map(PhotoResponse::toPhotoInfo)

private fun PhotoResponse.toPhotoInfo() = PhotoInfo(id, title, farmId, secret, serverId)