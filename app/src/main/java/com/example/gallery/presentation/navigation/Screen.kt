package com.example.gallery.presentation.navigation

import com.example.gallery.presentation.gallery.GalleryFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen : SupportAppScreen() {

    object Gallery : Screen() {
        override fun getFragment() = GalleryFragment.newInstance()
    }
}
