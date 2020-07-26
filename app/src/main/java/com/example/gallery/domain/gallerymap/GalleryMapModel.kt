package com.example.gallery.domain.gallerymap

import com.example.gallery.domain.GalleryRepository
import com.example.gallery.domain.core.BaseModel
import com.example.gallery.domain.core.EmptyState
import javax.inject.Inject

class GalleryMapModel
@Inject constructor(
    @SearchTextArgument private val searchText: String,
    private val galleryRepository: GalleryRepository
) : BaseModel<EmptyState>(EmptyState), GalleryMapInteractor