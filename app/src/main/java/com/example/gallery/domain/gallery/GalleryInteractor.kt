package com.example.gallery.domain.gallery

import com.example.gallery.domain.core.Interactor
import io.reactivex.Single

interface GalleryInteractor : Interactor<GalleryState> {

    fun imageTagChanged(searchText: String)

    fun loadImages(searchText: String): Single<List<PhotoInfo>>
}