package com.example.gallery.presentation

import com.example.gallery.presentation.mainactivity.MainActivity
import com.example.gallery.presentation.mainactivity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            FragmentBuilder::class
        ]
    )
    fun mainActivityInjector(): MainActivity
}