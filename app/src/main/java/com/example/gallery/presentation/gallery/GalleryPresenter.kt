package com.example.gallery.presentation.gallery

import android.os.Handler
import android.os.Looper
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.gallery.domain.core.Logger
import com.example.gallery.domain.core.Schedulers
import com.example.gallery.domain.gallery.GalleryInteractor
import com.example.gallery.domain.gallery.GalleryState
import com.example.gallery.domain.gallery.PhotoInfo
import com.example.gallery.presentation.core.BasePresenter
import com.example.gallery.presentation.gallery.adapter.PhotoInfoItem
import com.example.gallery.presentation.navigation.Screen
import io.reactivex.rxkotlin.subscribeBy
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

private const val START_PAGE = 1
private const val PAGE_SIZE = 20

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
            { it.searchText.isNotBlank() },
            viewState::renderFindButton
        )
    }

    fun onSearchTextChanged(searchText: String) {
        interactor.searchTextChanged(searchText)
    }

    fun onPhotoItemClick(photoItem: PhotoInfoItem) {
        router.navigateTo(Screen.GalleryDetail(photoItem.toParcelablePhotoInfo()))
    }

    fun onFindButtonClick() {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .build()
        val pagedList = PagedList.Builder(PagedDataSource(), pagedListConfig)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .setNotifyExecutor(MainThreadExecutor())
            .build()
        viewState.renderList(pagedList)
    }

    private fun loadPagePhotosInfo(
        page: Int,
        callbackAction: (pages: Int, list: List<PhotoInfoItem>) -> Unit
    ) {
        disposeOnDestroy(
            interactor.loadPhotosInfo(page, PAGE_SIZE)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.main())
                .subscribeBy(
                    onSuccess = {
                        callbackAction(it.pages, it.photoInfo.map(PhotoInfo::toPhotoInfoItem))
                    },
                    onError = {
                        logger.logError(it)
                        viewState.showErrorOccurred()
                    }
                )
        )
    }

    inner class PagedDataSource : PageKeyedDataSource<Int, PhotoInfoItem>() {
        override fun loadInitial(
            params: LoadInitialParams<Int>,
            callback: LoadInitialCallback<Int, PhotoInfoItem>
        ) {
            loadPagePhotosInfo(START_PAGE) { _, list: List<PhotoInfoItem> ->
                callback.onResult(list, null, START_PAGE)
            }
        }

        override fun loadAfter(
            params: LoadParams<Int>,
            callback: LoadCallback<Int, PhotoInfoItem>
        ) {
            val page = params.key + 1
            loadPagePhotosInfo(page) { _, list: List<PhotoInfoItem> ->
                callback.onResult(list, page)
            }
        }

        override fun loadBefore(
            params: LoadParams<Int>,
            callback: LoadCallback<Int, PhotoInfoItem>
        ) {
            // no op
        }
    }
}

private class MainThreadExecutor : Executor {
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mHandler.post(command)
    }
}