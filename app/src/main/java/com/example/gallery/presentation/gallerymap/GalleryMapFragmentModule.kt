package com.example.gallery.presentation.gallerymap

import com.example.gallery.domain.gallerymap.GalleryMapModule
import com.example.gallery.domain.gallerymap.SearchTextArgument
import dagger.Module
import dagger.Provides

@Module(includes = [GalleryMapModule::class])
interface GalleryMapFragmentModule {

    companion object {
        @Provides
        @SearchTextArgument
        fun provideSearchTextArgument(galleryMapFragment: GalleryMapFragment) =
            galleryMapFragment.searchText
    }
}