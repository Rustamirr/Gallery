package com.example.gallery.presentation.gallerymap

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gallery.databinding.FragmentGalleryMapBinding
import com.example.gallery.domain.core.EmptyState
import com.example.gallery.presentation.core.BaseFragment

class GalleryMapFragment :
    BaseFragment<FragmentGalleryMapBinding, EmptyState, GalleryMapPresenter>(), GalleryMapView {

    companion object {
        fun newInstance(searchText: String) = GalleryMapFragment()
    }

    override fun LayoutInflater.createBinding(container: ViewGroup?): FragmentGalleryMapBinding =
        FragmentGalleryMapBinding.inflate(this, container, false)
}