package com.example.gallery.domain.gallerydetail

import com.example.gallery.domain.core.BaseModel
import com.example.gallery.domain.core.EmptyState
import javax.inject.Inject

class GalleryDetailModel
@Inject constructor() : BaseModel<EmptyState>(EmptyState), GalleryDetailInteractor