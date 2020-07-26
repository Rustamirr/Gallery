package com.example.gallery.presentation.gallery

import com.example.gallery.domain.PhotoInfo
import com.example.gallery.presentation.gallery.adapter.PhotoInfoItem

fun PhotoInfo.toPhotoInfoItem() = PhotoInfoItem(id, title, url)

fun PhotoInfoItem.toParcelablePhotoInfo() = ParcelablePhotoInfo(id, title, url)