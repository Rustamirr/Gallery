package com.example.gallery.domain.gallerydetail

import dagger.Binds
import dagger.Module

@Module
interface GalleryDetailModule {

    @Binds
    fun bindGalleryDetailInteractor(galleryDetailModel: GalleryDetailModel): GalleryDetailInteractor
}