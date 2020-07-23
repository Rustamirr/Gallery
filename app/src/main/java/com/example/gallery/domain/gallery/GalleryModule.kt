package com.example.gallery.domain.gallery

import dagger.Binds
import dagger.Module

@Module
interface GalleryModule {

    @Binds
    fun bindGalleryInteractor(galleryModel: GalleryModel): GalleryInteractor
}