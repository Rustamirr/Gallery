package com.example.gallery.domain.gallery

import com.example.gallery.domain.core.BaseModel
import javax.inject.Inject

class GalleryModel
@Inject constructor(
    private val galleryRepository: GalleryRepository
) : BaseModel<GalleryState>(GalleryState()), GalleryInteractor {

    override fun loadPhotosInfo(page: Int, pageSize: Int, searchText: String) =
        galleryRepository.searchPhotosByText(page, pageSize, searchText)

    override fun searchTextChanged(searchText: String) {
        updateState {
            copy(isSearchTextFilled = searchText.isNotEmpty())
        }
    }
}