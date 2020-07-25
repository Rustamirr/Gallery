package com.example.gallery.presentation.gallery

import androidx.paging.PagedList
import com.example.gallery.presentation.core.BaseView
import com.example.gallery.presentation.gallery.adapter.PhotoInfoItem
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface GalleryView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun renderFindButton(isEnabled: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun renderList(list: PagedList<PhotoInfoItem>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showErrorOccurred()
}