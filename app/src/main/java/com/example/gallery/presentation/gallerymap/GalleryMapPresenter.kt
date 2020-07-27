package com.example.gallery.presentation.gallerymap

import com.example.gallery.domain.PhotoInfo
import com.example.gallery.domain.core.Logger
import com.example.gallery.domain.core.Schedulers
import com.example.gallery.domain.gallerymap.GalleryMapInteractor
import com.example.gallery.domain.gallerymap.GalleryMapState
import com.example.gallery.presentation.core.BasePresenter
import com.example.gallery.presentation.toMapMarkerInfo
import io.reactivex.rxkotlin.subscribeBy
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
) : BasePresenter<GalleryMapState, GalleryMapView, GalleryMapInteractor>(
    router,
    interactor,
    schedulers,
    logger
) {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposeOnDestroy(
            interactor.observeState()
                .doOnNext {
                    viewState.renderMapMarkers(it.photoInfo.map(PhotoInfo::toMapMarkerInfo))
                }
                .subscribeBy(onError = logger::logError)
        )
    }

    fun onMapReady() {
        disposeOnDestroy(
            interactor.loadPhotosInfoGeo()
                .subscribeBy(onError = logger::logError)
        )
    }
}