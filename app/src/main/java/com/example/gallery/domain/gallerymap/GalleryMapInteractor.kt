package com.example.gallery.domain.gallerymap

import com.example.gallery.domain.core.Interactor
import io.reactivex.Completable

interface GalleryMapInteractor : Interactor<GalleryMapState> {

    fun loadPhotosInfoGeo(): Completable
}