package com.example.gallery.presentation.gallery

import com.example.gallery.domain.gallery.PhotoInfo
import com.example.gallery.presentation.gallery.adapter.PhotoInfoItem

fun PhotoInfo.toPhotoInfoItem() = PhotoInfoItem(id, title, farmId, secret, serverId)

fun PhotoInfoItem.toParcelablePhotoInfo() = ParcelablePhotoInfo(id, title, farmId, secret, serverId)