package com.example.gallery

import android.content.Context
import com.example.gallery.data.AppDataModule
import com.example.gallery.presentation.PresentationModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        PresentationModule::class,
        AppDataModule::class
    ]
)
abstract class ApplicationModule {

    companion object {
        @Provides
        fun providesContext(application: App): Context = application
    }
}