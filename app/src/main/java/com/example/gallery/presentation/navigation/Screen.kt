package com.example.gallery.presentation.navigation

import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen : SupportAppScreen() {

    object Gallery : Screen() {
        override fun getFragment() = TODO("GalleryFragment.newInstance()")
    }
}
