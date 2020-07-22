package com.example.gallery.presentation.navigation

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
interface NavigationModule {

    companion object {

        @Singleton
        @Provides
        fun provideCicerone(): Cicerone<Router> = Cicerone.create()

        @Provides
        fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder =
            cicerone.navigatorHolder

        @Provides
        fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router
    }
}