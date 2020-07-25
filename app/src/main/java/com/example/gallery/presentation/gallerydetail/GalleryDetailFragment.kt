package com.example.gallery.presentation.gallerydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.gallery.databinding.FragmentGalleryDetailBinding
import com.example.gallery.domain.core.EmptyState
import com.example.gallery.presentation.core.BaseFragment
import com.example.gallery.presentation.gallery.ParcelablePhotoInfo

private const val ARGUMENT_PHOTO = "ARGUMENT_PHOTO"

class GalleryDetailFragment :
    BaseFragment<FragmentGalleryDetailBinding, EmptyState, GalleryDetailPresenter>(),
    GalleryDetailView {

    companion object {
        fun newInstance(photoInfo: ParcelablePhotoInfo) = GalleryDetailFragment()
            .apply {
                arguments = bundleOf(ARGUMENT_PHOTO to photoInfo)
            }
    }

    private val photoInfo by lazy<ParcelablePhotoInfo> {
        requireNotNull(arguments?.getParcelable(ARGUMENT_PHOTO))
    }

    override fun LayoutInflater.createBinding(container: ViewGroup?): FragmentGalleryDetailBinding =
        FragmentGalleryDetailBinding.inflate(this, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = photoInfo.title
        Glide.with(this)
            .load(photoInfo.url)
            .fitCenter()
            .into(binding.photo)
    }
}