package com.example.gallery.domain.gallery

import com.example.gallery.domain.core.BaseModel
import com.example.gallery.domain.core.Schedulers
import io.reactivex.Completable
import javax.inject.Inject

class GalleryModel
@Inject constructor(
    private val galleryRepository: GalleryRepository,
    private val schedulers: Schedulers
) : BaseModel<GalleryState>(GalleryState()), GalleryInteractor {

    override fun loadPhotosInfo(page: Int, searchText: String): Completable =
        galleryRepository.searchPhotosByText(page, searchText)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .doOnSuccess {
                updateState { copy(photoInfoList = it) }
            }
            .ignoreElement()

    override fun searchTextChanged(searchText: String) {
        updateState {
            copy(isSearchTextFilled = searchText.isNotEmpty())
        }
    }
}