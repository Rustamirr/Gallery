package com.example.gallery.presentation.gallerymap

import com.example.gallery.presentation.core.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface GalleryMapView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun renderMapMarkers(list: List<MapMarkerInfo>)
}