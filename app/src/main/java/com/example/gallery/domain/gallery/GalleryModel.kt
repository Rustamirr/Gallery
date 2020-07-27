package com.example.gallery.domain.gallery

import com.example.gallery.domain.GalleryRepository
import com.example.gallery.domain.core.BaseModel
import com.example.gallery.domain.core.Schedulers
import javax.inject.Inject

class GalleryModel
@Inject constructor(
    private val repository: GalleryRepository,
    private val schedulers: Schedulers
) : BaseModel<GalleryState>(GalleryState()), GalleryInteractor {

    override fun loadPhotosInfo(page: Int) = observeState()
        .firstOrError()
        .flatMap {
            repository.loadPhotosInfo(it.searchText, page)
                .subscribeOn(schedulers.io())
        }

    override fun searchTextChanged(searchText: String) {
        updateState {
            copy(searchText = searchText)
        }
    }
}