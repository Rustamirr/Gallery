package com.example.gallery.domain.gallery

import com.example.gallery.domain.core.BaseModel
import javax.inject.Inject

class GalleryModel
@Inject constructor(
    private val galleryRepository: GalleryRepository
) : BaseModel<GalleryState>(GalleryState()), GalleryInteractor {

    override fun imageTagChanged(searchText: String) {
        updateState {
            copy(isSearchTextFilled = searchText.isNotEmpty())
        }
    }

    override fun loadImages(searchText: String) =
        galleryRepository.searchPhotosByText(1, searchText)
}