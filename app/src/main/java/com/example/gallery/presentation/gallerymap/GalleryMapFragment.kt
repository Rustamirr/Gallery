package com.example.gallery.presentation.gallerymap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.gallery.R
import com.example.gallery.databinding.FragmentGalleryMapBinding
import com.example.gallery.domain.core.EmptyState
import com.example.gallery.presentation.core.BaseFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
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

    val searchText by lazy { requireNotNull(arguments?.getString(ARGUMENT_SEARCH_TEXT)) }
    lateinit var map: GoogleMap

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
        map.addMarker(
            MarkerOptions()
                .title(markerInfo.title)
                .position(LatLng(markerInfo.latitude, markerInfo.longitude))
        )
    }
}