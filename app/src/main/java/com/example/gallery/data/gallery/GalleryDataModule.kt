package com.example.gallery.data.gallery

import com.example.gallery.data.gallery.network.GalleryNetworkApi
import com.example.gallery.data.gallery.network.GalleryNetworkSource
import com.example.gallery.data.gallery.network.GalleryNetworkSourceImpl
import com.example.gallery.domain.GalleryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
interface GalleryDataModule {

    companion object {
        @Singleton
        @Provides
        fun provideGalleryNetworkApi(retrofit: Retrofit): GalleryNetworkApi =
            retrofit.create(GalleryNetworkApi::class.java)
    }

    @Singleton
    @Binds
    fun bindGalleryRepository(galleryRepositoryImpl: GalleryRepositoryImpl): GalleryRepository

    @Singleton
    @Binds
    fun bindGalleryNetworkSource(galleryNetworkSourceImpl: GalleryNetworkSourceImpl): GalleryNetworkSource
}