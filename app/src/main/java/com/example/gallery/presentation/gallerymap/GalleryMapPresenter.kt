package com.example.gallery.presentation.gallerymap

import com.example.gallery.domain.core.EmptyState
import com.example.gallery.domain.core.Logger
import com.example.gallery.domain.core.Schedulers
import com.example.gallery.domain.gallerymap.GalleryMapInteractor
import com.example.gallery.presentation.core.BasePresenter
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class GalleryMapPresenter
@Inject constructor(
    router: Router,
    interactor: GalleryMapInteractor,
    schedulers: Schedulers,
    logger: Logger
) : BasePresenter<EmptyState, GalleryMapView, GalleryMapInteractor>(
    router,
    interactor,
    schedulers,
    logger
)