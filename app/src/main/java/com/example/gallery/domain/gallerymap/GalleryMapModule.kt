package com.example.gallery.domain.gallerymap

import dagger.Binds
import dagger.Module

@Module
interface GalleryMapModule {

    @Binds
    fun bindGalleryMapInteractor(galleryMapModel: GalleryMapModel): GalleryMapInteractor
}