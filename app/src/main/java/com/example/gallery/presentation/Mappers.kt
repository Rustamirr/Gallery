package com.example.gallery.presentation

import com.example.gallery.domain.PhotoInfo
import com.example.gallery.presentation.gallery.adapter.PhotoInfoItem
import com.example.gallery.presentation.gallerymap.MapMarkerInfo

fun PhotoInfo.toPhotoInfoItem() = PhotoInfoItem(id, title, url)

fun PhotoInfo.toMapMarkerInfo() = MapMarkerInfo(
    id, title, url, requireNotNull(latitude), requireNotNull(longitude)
)