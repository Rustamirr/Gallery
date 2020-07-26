package com.example.gallery.domain.gallerymap

import dagger.Binds
import dagger.Module
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class SearchTextArgument

@Module
interface GalleryMapModule {

    @Binds
    fun bindGalleryMapInteractor(galleryMapModel: GalleryMapModel): GalleryMapInteractor
}