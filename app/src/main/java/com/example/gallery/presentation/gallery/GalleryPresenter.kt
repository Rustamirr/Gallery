package com.example.gallery.presentation.gallery

import com.example.gallery.domain.core.Logger
import com.example.gallery.domain.core.Schedulers
import com.example.gallery.domain.gallery.GalleryInteractor
import com.example.gallery.domain.gallery.GalleryState
import com.example.gallery.presentation.core.BasePresenter
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class GalleryPresenter
@Inject constructor(
    router: Router,
    interactor: GalleryInteractor,
    schedulers: Schedulers,
    logger: Logger
) : BasePresenter<GalleryState, GalleryView, GalleryInteractor>(
    router,
    interactor,
    schedulers,
    logger
) {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        mapStateToRender(
            GalleryState::isImageTagFilled,
            viewState::renderFindButton
        )
    }

    fun onImageTagChanged(imageTag: String) {
        interactor.imageTagChanged(imageTag)
    }

    fun onFindClick(imageTag: String) {
        interactor.loadImages(imageTag)
    }
}