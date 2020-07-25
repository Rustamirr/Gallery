package com.example.gallery.presentation.navigation

import com.example.gallery.presentation.gallery.GalleryFragment
import com.example.gallery.presentation.gallery.ParcelablePhotoInfo
import com.example.gallery.presentation.gallerydetail.GalleryDetailFragment
import com.example.gallery.presentation.gallerymap.GalleryMapFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen : SupportAppScreen() {

    object Gallery : Screen() {
        override fun getFragment() = GalleryFragment.newInstance()
    }

    data class GalleryDetail(private val photoInfo: ParcelablePhotoInfo) : Screen() {
        override fun getFragment() = GalleryDetailFragment.newInstance(photoInfo)
    }

    data class GalleryMap(private val searchText: String) : Screen() {
        override fun getFragment() = GalleryMapFragment.newInstance(searchText)
    }
}
