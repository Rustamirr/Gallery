package com.example.gallery.presentation.gallerymap

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.gallery.R
import com.example.gallery.databinding.FragmentGalleryMapBinding
import com.example.gallery.domain.core.EmptyState
import com.example.gallery.presentation.core.BaseFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val ARGUMENT_SEARCH_TEXT = "ARGUMENT_SEARCH_TEXT"

class GalleryMapFragment :
    BaseFragment<FragmentGalleryMapBinding, EmptyState, GalleryMapPresenter>(), GalleryMapView,
    OnMapReadyCallback {

    companion object {
        fun newInstance(searchText: String) = GalleryMapFragment()
            .apply {
                arguments = bundleOf(ARGUMENT_SEARCH_TEXT to searchText)
            }
    }

    private lateinit var map: GoogleMap
    private val glideManager by lazy { Glide.with(this) }
    private val mapMarkerSize by lazy { resources.getDimensionPixelSize(R.dimen.map_marker_size) }

    val searchText by lazy { requireNotNull(arguments?.getString(ARGUMENT_SEARCH_TEXT)) }

    override fun LayoutInflater.createBinding(container: ViewGroup?): FragmentGalleryMapBinding =
        FragmentGalleryMapBinding.inflate(this, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.map)
        with(binding.mapView) {
            onCreate(savedInstanceState)
            getMapAsync(this@GalleryMapFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
        presenter.onMapReady()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onDestroyView() {
        binding.mapView.onDestroy()
        super.onDestroyView()
    }

    override fun onLowMemory() {
        binding.mapView.onLowMemory()
        super.onLowMemory()
    }

    override fun renderMapMarkers(markerInfo: MapMarkerInfo) {
        glideManager
            .asBitmap()
            .load(markerInfo.url)
            .into(object : CustomTarget<Bitmap>(mapMarkerSize, mapMarkerSize) {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap>?
                ) {
                    map.addMarker(
                        MarkerOptions()
                            .position(LatLng(markerInfo.latitude, markerInfo.longitude))
                            .title(markerInfo.title)
                            .icon(BitmapDescriptorFactory.fromBitmap(resource))
                    )
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // no op
                }
            })
    }
}