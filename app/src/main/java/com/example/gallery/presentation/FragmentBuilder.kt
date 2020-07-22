package com.example.gallery.presentation

import com.example.gallery.presentation.gallery.GalleryFragment
import com.example.gallery.presentation.gallery.GalleryFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilder {

    @ContributesAndroidInjector(
        modules = [
            GalleryFragmentModule::class
        ]
    )
    fun galleryFragmentInjector(): GalleryFragment
}