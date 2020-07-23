package com.example.gallery.presentation

import com.example.gallery.presentation.navigation.NavigationModule
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@Module(
    includes = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        NavigationModule::class
    ]
)
interface PresentationModule