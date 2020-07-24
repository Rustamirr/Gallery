package com.example.gallery.presentation.navigation

import com.example.gallery.presentation.gallery.GalleryFragment
import com.example.gallery.presentation.gallery.ParcelablePhoto
import com.example.gallery.presentation.gallerydetail.GalleryDetailFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen : SupportAppScreen() {

    object Gallery : Screen() {
        override fun getFragment() = GalleryFragment.newInstance()
    }

    data class GalleryDetail(private val photo: ParcelablePhoto) : Screen() {
        override fun getFragment() = GalleryDetailFragment.newInstance(photo)
    }
}
