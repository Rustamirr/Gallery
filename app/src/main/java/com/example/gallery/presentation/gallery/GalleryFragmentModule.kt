package com.example.gallery.presentation.gallery

import com.example.gallery.domain.gallery.GalleryModule
import dagger.Module

@Module(includes = [GalleryModule::class])
interface GalleryFragmentModule