package com.example.gallery.domain.gallery

import com.example.gallery.domain.core.Interactor
import io.reactivex.Completable

interface GalleryInteractor : Interactor<GalleryState> {

    fun loadPhotosInfo(page: Int, searchText: String): Completable

    fun searchTextChanged(searchText: String)
}