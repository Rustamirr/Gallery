package com.example.gallery.domain.gallery

import com.example.gallery.domain.PhotoInfo
import com.example.gallery.domain.core.Interactor
import io.reactivex.Single

interface GalleryInteractor : Interactor<GalleryState> {

    fun loadPhotosInfo(page: Int): Single<List<PhotoInfo>>

    fun searchTextChanged(searchText: String)
}