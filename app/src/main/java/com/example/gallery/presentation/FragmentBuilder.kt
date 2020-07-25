package com.example.gallery.presentation

import com.example.gallery.presentation.gallery.GalleryFragment
import com.example.gallery.presentation.gallery.GalleryFragmentModule
import com.example.gallery.presentation.gallerydetail.GalleryDetailFragment
import com.example.gallery.presentation.gallerydetail.GalleryDetailFragmentModule
import com.example.gallery.presentation.gallerymap.GalleryMapFragment
import com.example.gallery.presentation.gallerymap.GalleryMapFragmentModule
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

    @ContributesAndroidInjector(
        modules = [
            GalleryDetailFragmentModule::class
        ]
    )
    fun galleryDetailFragmentInjector(): GalleryDetailFragment

    @ContributesAndroidInjector(
        modules = [
            GalleryMapFragmentModule::class
        ]
    )
    fun galleryMapFragmentInjector(): GalleryMapFragment
}