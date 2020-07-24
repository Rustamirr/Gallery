package com.example.gallery.presentation.gallery

import com.example.gallery.domain.gallery.PhotoInfo
import com.example.gallery.presentation.gallery.adapter.PhotoItem

fun PhotoInfo.toPhotoItem() = PhotoItem(id, title, farmId, secret, serverId)

fun PhotoItem.toParcelablePhotoInfo() = ParcelablePhotoInfo(id, title, farmId, secret, serverId)