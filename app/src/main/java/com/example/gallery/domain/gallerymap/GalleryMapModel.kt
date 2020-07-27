package com.example.gallery.domain.gallerymap

import com.example.gallery.domain.GalleryRepository
import com.example.gallery.domain.core.BaseModel
import com.example.gallery.domain.core.Schedulers
import io.reactivex.Completable
import javax.inject.Inject

private const val PAGE = 1

class GalleryMapModel
@Inject constructor(
    @SearchTextArgument private val searchText: String,
    private val repository: GalleryRepository,
    private val schedulers: Schedulers
) : BaseModel<GalleryMapState>(GalleryMapState()), GalleryMapInteractor {

    override fun loadPhotosInfoGeo(): Completable =
        repository.loadPhotosInfoGeo("Moscow", PAGE)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .doOnSuccess {
                updateState { copy(photoInfo = it) }
            }
            .ignoreElement()
}