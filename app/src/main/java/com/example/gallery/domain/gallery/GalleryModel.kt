package com.example.gallery.domain.gallery

import com.example.gallery.domain.core.BaseModel
import javax.inject.Inject

class GalleryModel
@Inject constructor(
    private val galleryRepository: GalleryRepository
) : BaseModel<GalleryState>(GalleryState()), GalleryInteractor {

    override fun imageTagChanged(imageTag: String) {
        updateState {
            copy(isImageTagFilled = imageTag.isNotEmpty())
        }
    }

    override fun loadImages(imageTag: String) = galleryRepository.getGalleryImages(imageTag)
}