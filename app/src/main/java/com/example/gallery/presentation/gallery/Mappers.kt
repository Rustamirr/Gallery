package com.example.gallery.presentation.gallery

import com.example.gallery.domain.gallery.Photo
import com.example.gallery.presentation.gallery.adapter.GalleryItem

fun Photo.toGalleryItem() = GalleryItem(id, title, farmId, secret, serverId)

fun GalleryItem.toParcelablePhoto() = ParcelablePhoto(id, title, farmId, secret, serverId)