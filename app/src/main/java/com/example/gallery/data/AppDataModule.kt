package com.example.gallery.data

import com.example.gallery.data.gallery.GalleryDataModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.flickr.com/"

@Module(includes = [GalleryDataModule::class])
interface AppDataModule {
    companion object {
        @Singleton
        @Provides
        fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}