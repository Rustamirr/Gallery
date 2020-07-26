package com.example.gallery.domain.gallery

import com.example.gallery.domain.GalleryRepository
import com.example.gallery.domain.core.BaseModel
import javax.inject.Inject

class GalleryModel
@Inject constructor(
    private val galleryRepository: GalleryRepository
) : BaseModel<GalleryState>(GalleryState()), GalleryInteractor {

    override fun loadPhotosInfo(page: Int, pageSize: Int) = observeState()
        .firstOrError()
        .flatMap {
            galleryRepository.searchPhotos(page, pageSize, it.searchText)
        }

    override fun searchTextChanged(searchText: String) {
        updateState {
            copy(searchText = searchText)
        }
    }
}