package com.example.gallery

import android.content.Context
import com.example.gallery.data.AppDataModule
import com.example.gallery.domain.core.CoreModule
import com.example.gallery.presentation.PresentationModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        PresentationModule::class,
        CoreModule::class,
        AppDataModule::class
    ]
)
interface ApplicationModule {

    companion object {
        @Provides
        fun providesContext(application: App): Context = application
    }
}