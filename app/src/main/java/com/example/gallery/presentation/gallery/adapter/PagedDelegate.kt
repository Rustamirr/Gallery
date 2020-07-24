package com.example.gallery.presentation.gallery.adapter

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import java.util.concurrent.Executors

class PagedDelegate {
    private val pagedDataSource = PagedDataSource(this)
    private val pagedDataSourceFactory = PagedDataSourceFactory(pagedDataSource)
    private val pageListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(20)
        .setPageSize(20)
        .build()

    lateinit var list: List<PhotoInfoItem>

    fun observePagedList(): LiveData<PagedList<PhotoInfoItem>> =
        LivePagedListBuilder<Int, PhotoInfoItem>(pagedDataSourceFactory, pageListConfig)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()
}

private class PagedDataSourceFactory(
    private val pagedDataSource: PagedDataSource
) : DataSource.Factory<Int, PhotoInfoItem>() {

    override fun create() = pagedDataSource
}

private class PagedDataSource(
    private val storage: PagedDelegate
) : PageKeyedDataSource<Int, PhotoInfoItem>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, PhotoInfoItem>
    ) {
        callback.onResult(storage.list, null, 1)
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, PhotoInfoItem>
    ) {
        callback.onResult(storage.list, 2)
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, PhotoInfoItem>
    ) {
    }
}