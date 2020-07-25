package com.example.gallery.domain.gallery

import com.example.gallery.domain.core.Interactor
import io.reactivex.Single

interface GalleryInteractor : Interactor<GalleryState> {

    fun loadPhotosInfo(page: Int, pageSize: Int): Single<PhotosInfo>

    fun searchTextChanged(searchText: String)
}