package com.example.gallery.presentation.gallery

import com.example.gallery.presentation.core.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface GalleryView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun renderFindButton(isEnabled: Boolean)
}