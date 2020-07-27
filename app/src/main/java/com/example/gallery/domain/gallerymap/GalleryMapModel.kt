package com.example.gallery.domain.gallerymap

import com.example.gallery.domain.GalleryRepository
import com.example.gallery.domain.PhotoInfo
import com.example.gallery.domain.core.BaseModel
import com.example.gallery.domain.core.EmptyState
import io.reactivex.Observable
import javax.inject.Inject

private const val PAGE = 1

class GalleryMapModel
@Inject constructor(
    @SearchTextArgument private val searchText: String,
    private val repository: GalleryRepository
) : BaseModel<EmptyState>(EmptyState), GalleryMapInteractor {

    override fun loadPhotosInfoGeo(): Observable<PhotoInfo> =
        repository.loadPhotosInfoGeo(searchText, PAGE)
}