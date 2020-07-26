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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng


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

    override fun LayoutInflater.createBinding(container: ViewGroup?): FragmentGalleryMapBinding =
        FragmentGalleryMapBinding.inflate(this, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.map)
        binding.mapView.getMapAsync(this)
    }

    /*override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        binding.mapView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        binding.mapView.onDestroy()
        super.onDestroy()
    }*/

    override fun onMapReady(map: GoogleMap) {
        map.moveCamera(CameraUpdateFactory.newLatLng(LatLng(43.1, -87.9)))
    }


}