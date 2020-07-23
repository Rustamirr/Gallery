package com.example.gallery.presentation.gallery

import com.example.gallery.presentation.core.BaseView
import com.example.gallery.presentation.gallery.adapter.GalleryItem
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface GalleryView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun renderFindButton(isEnabled: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun renderList(list: List<GalleryItem>)
}