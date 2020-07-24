package com.example.gallery.presentation.gallery

import com.example.gallery.domain.core.Logger
import com.example.gallery.domain.core.Schedulers
import com.example.gallery.domain.gallery.GalleryInteractor
import com.example.gallery.domain.gallery.GalleryState
import com.example.gallery.domain.gallery.PhotoInfo
import com.example.gallery.presentation.core.BasePresenter
import com.example.gallery.presentation.gallery.adapter.PhotoInfoItem
import com.example.gallery.presentation.navigation.Screen
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
        mapStateToRender(
            {
                it.photoInfoList.map(PhotoInfo::toPhotoInfoItem)
            },
            viewState::renderList
        )
    }

    fun onSearchTextChanged(searchText: String) {
        interactor.searchTextChanged(searchText)
    }

    fun onPhotoClick(photoItem: PhotoInfoItem) {
        router.navigateTo(Screen.GalleryDetail(photoItem.toParcelablePhotoInfo()))
    }


    fun onFindButtonClick(searchText: String) {
        /*disposeOnDestroy(
            interactor.loadPhotosInfo(searchText)
                .subscribeBy(onError = {
                    logger.logError(it)
                    viewState.showErrorOccurred()
                })
        )*/
    }
}