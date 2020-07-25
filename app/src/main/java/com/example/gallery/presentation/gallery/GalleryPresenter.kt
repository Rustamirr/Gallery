package com.example.gallery.presentation.gallery

import androidx.paging.PageKeyedDataSource
import com.example.gallery.domain.core.Logger
import com.example.gallery.domain.core.Schedulers
import com.example.gallery.domain.gallery.GalleryInteractor
import com.example.gallery.domain.gallery.GalleryState
import com.example.gallery.domain.gallery.PhotoInfo
import com.example.gallery.presentation.core.BasePresenter
import com.example.gallery.presentation.gallery.adapter.PagedDelegate
import com.example.gallery.presentation.gallery.adapter.PhotoInfoItem
import io.reactivex.rxkotlin.subscribeBy
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class GalleryPresenter
@Inject constructor(
    private val pagedDelegate: PagedDelegate,
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
        interactor.searchTextChanged(searchText)
    }

    /*fun onPhotoClick(photoItem: PhotoInfoItem) {
        router.navigateTo(Screen.GalleryDetail(photoItem.toParcelablePhotoInfo()))
    }*/

    fun onFindButtonClick(searchText: String) {
        viewState.renderList(
            pagedDelegate.getPagedList(
                loadFirstPage = { page: Int, pageSize: Int, callback: PageKeyedDataSource.LoadInitialCallback<Int, PhotoInfoItem> ->
                    disposeOnDestroy(
                        interactor.loadPhotosInfo(page, pageSize, searchText)
                            .subscribeOn(schedulers.io())
                            .observeOn(schedulers.main())
                            .subscribeBy(
                                onSuccess = {
                                    val list = it.map(PhotoInfo::toPhotoInfoItem)
                                    callback.onResult(list, null, page)
                                },
                                onError = {
                                    logger.logError(it)
                                    viewState.showErrorOccurred()
                                }
                            )
                    )
                },
                loadNextPage = { page: Int, pageSize: Int, callback: PageKeyedDataSource.LoadCallback<Int, PhotoInfoItem> ->
                    disposeOnDestroy(
                        interactor.loadPhotosInfo(page, pageSize, searchText)
                            .subscribeOn(schedulers.io())
                            .observeOn(schedulers.main())
                            .subscribeBy(
                                onSuccess = {
                                    val list = it.map(PhotoInfo::toPhotoInfoItem)
                                    callback.onResult(list, page)
                                },
                                onError = {
                                    logger.logError(it)
                                    viewState.showErrorOccurred()
                                }
                            )
                    )
                }
            )
        )
    }

    fun loadFirstPage(
        page: Int,
        pageSize: Int,
        callback: PageKeyedDataSource.LoadInitialCallback<Int, PhotoInfoItem>
    ) {

    }
}