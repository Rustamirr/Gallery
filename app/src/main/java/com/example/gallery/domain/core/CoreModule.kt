package com.example.gallery.domain.core

import com.example.gallery.presentation.core.LoggerImpl
import com.example.gallery.presentation.core.SchedulersImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface CoreModule {

    @Singleton
    @Binds
    fun bindSchedulers(schedulers: SchedulersImpl): Schedulers

    @Singleton
    @Binds
    fun bindLogger(loggerImpl: LoggerImpl): Logger
}