package com.example.gallery.presentation.gallery

import com.example.gallery.domain.core.Logger
import com.example.gallery.domain.core.Schedulers
import com.example.gallery.domain.gallery.GalleryInteractor
import com.example.gallery.domain.gallery.GalleryState
import com.example.gallery.domain.gallery.Photo
import com.example.gallery.presentation.core.BasePresenter
import com.example.gallery.presentation.gallery.adapter.toGalleryItem
import io.reactivex.rxkotlin.subscribeBy
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
            GalleryState::isSearchTextFilled,
            viewState::renderFindButton
        )
    }

    fun onSearchTextChanged(searchText: String) {
        interactor.imageTagChanged(searchText)
    }

    fun onFindButtonClick(searchText: String) {
        disposeOnDestroy(
            interactor.loadImages(searchText)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.main())
                .subscribeBy(
                    onSuccess = { viewState.renderList(it.map(Photo::toGalleryItem)) },
                    onError = logger::logError
                )
        )
    }
}