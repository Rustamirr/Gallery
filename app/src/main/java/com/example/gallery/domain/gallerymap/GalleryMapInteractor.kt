package com.example.gallery.domain.gallerymap

import com.example.gallery.domain.PhotoInfo
import com.example.gallery.domain.core.EmptyState
import com.example.gallery.domain.core.Interactor
import io.reactivex.Observable

interface GalleryMapInteractor : Interactor<EmptyState> {

    fun loadPhotosInfoGeo(): Observable<PhotoInfo>
}