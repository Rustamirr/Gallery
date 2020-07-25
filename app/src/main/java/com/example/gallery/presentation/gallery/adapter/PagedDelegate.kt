package com.example.gallery.presentation.gallery.adapter

import android.os.Handler
import android.os.Looper
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

private const val START_PAGE = 1
private const val PAGE_SIZE = 20

class PagedDelegate
@Inject constructor() {

    fun getPagedList(
        loadFirstPage: (page: Int, pageSize: Int, callback: PageKeyedDataSource.LoadInitialCallback<Int, PhotoInfoItem>) -> Unit,
        loadNextPage: (page: Int, pageSize: Int, callback: PageKeyedDataSource.LoadCallback<Int, PhotoInfoItem>) -> Unit
    ): PagedList<PhotoInfoItem> {
        val pagedDataSource = PagedDataSource(loadFirstPage, loadNextPage)
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .build()
        return PagedList.Builder(pagedDataSource, pagedListConfig)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .setNotifyExecutor(MainThreadExecutor())
            .build()
    }
}

class PagedDataSource(
    private val loadFirstPage: (page: Int, pageSize: Int, callback: LoadInitialCallback<Int, PhotoInfoItem>) -> Unit,
    private val loadNextPage: (page: Int, pageSize: Int, callback: LoadCallback<Int, PhotoInfoItem>) -> Unit
) : PageKeyedDataSource<Int, PhotoInfoItem>() {

    private var page: Int = START_PAGE

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, PhotoInfoItem>
    ) {
        loadFirstPage(page, PAGE_SIZE, callback)
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, PhotoInfoItem>
    ) {
        page++
        loadNextPage(page, PAGE_SIZE, callback)
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, PhotoInfoItem>
    ) {
        // no op
    }
}

private class MainThreadExecutor : Executor {
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mHandler.post(command)
    }
}