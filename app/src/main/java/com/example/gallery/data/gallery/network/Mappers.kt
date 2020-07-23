package com.example.gallery.data.gallery.network

import com.example.gallery.domain.gallery.Photo

fun SearchPhotosResponse.toListOfPhoto() = photosResponse.photoResponse
    .map(PhotoResponse::toPhoto)

private fun PhotoResponse.toPhoto() = Photo(id, title, farmId, secret, serverId)