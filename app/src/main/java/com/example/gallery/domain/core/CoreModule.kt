package com.example.gallery.domain.core

import dagger.Binds
import dagger.Module

@Module
interface CoreModule {

    @Binds
    fun bindSchedulers(schedulers: SchedulersImpl): Schedulers
}