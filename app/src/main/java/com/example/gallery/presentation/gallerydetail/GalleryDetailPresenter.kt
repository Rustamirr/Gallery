package com.example.gallery.presentation.gallerydetail

import com.example.gallery.domain.core.EmptyState
import com.example.gallery.domain.core.Logger
import com.example.gallery.domain.core.Schedulers
import com.example.gallery.domain.gallerydetail.GalleryDetailInteractor
import com.example.gallery.presentation.core.BasePresenter
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class GalleryDetailPresenter
@Inject constructor(
    router: Router,
    interactor: GalleryDetailInteractor,
    schedulers: Schedulers,
    logger: Logger
) : BasePresenter<EmptyState, GalleryDetailView, GalleryDetailInteractor>(
    router,
    interactor,
    schedulers,
    logger
)