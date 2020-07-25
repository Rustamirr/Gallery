package com.example.gallery.domain.gallerymap

import com.example.gallery.domain.core.BaseModel
import com.example.gallery.domain.core.EmptyState
import javax.inject.Inject

class GalleryMapModel
@Inject constructor() : BaseModel<EmptyState>(EmptyState), GalleryMapInteractor