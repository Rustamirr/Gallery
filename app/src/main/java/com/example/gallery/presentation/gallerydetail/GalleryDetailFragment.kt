package com.example.gallery.presentation.gallerydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.gallery.databinding.FragmentGalleryDetailBinding
import com.example.gallery.domain.core.EmptyState
import com.example.gallery.presentation.core.BaseFragment
import com.example.gallery.presentation.gallery.ParcelablePhoto

private const val ARGUMENT_PHOTO = "ARGUMENT_PHOTO"

class GalleryDetailFragment :
    BaseFragment<FragmentGalleryDetailBinding, EmptyState, GalleryDetailPresenter>(),
    GalleryDetailView {

    companion object {
        fun newInstance(photo: ParcelablePhoto) = GalleryDetailFragment()
            .apply {
                arguments = bundleOf(ARGUMENT_PHOTO to photo)
            }
    }

    val photo: ParcelablePhoto = requireNotNull(arguments?.getParcelable(ARGUMENT_PHOTO))

    override fun LayoutInflater.createBinding(container: ViewGroup?): FragmentGalleryDetailBinding =
        FragmentGalleryDetailBinding.inflate(this, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val a = photo
    }
}