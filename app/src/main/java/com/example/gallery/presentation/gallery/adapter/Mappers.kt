package com.example.gallery.presentation.gallery.adapter

import com.example.gallery.domain.gallery.Photo

fun Photo.toGalleryItem() = GalleryItem(id, title, farmId, secret, serverId)