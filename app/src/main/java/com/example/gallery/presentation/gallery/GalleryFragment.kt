package com.example.gallery.presentation.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.gallery.R
import com.example.gallery.databinding.FragmentGalleryBinding
import com.example.gallery.domain.gallery.GalleryState
import com.example.gallery.presentation.core.BaseFragment
import com.example.gallery.presentation.gallery.adapter.GalleryAdapter
import com.example.gallery.presentation.gallery.adapter.GalleryViewHolderCreator
import com.example.gallery.presentation.gallery.adapter.PhotoInfoItem

private const val RECYCLER_VIEW_COLUMN_COUNT = 4

class GalleryFragment : BaseFragment<FragmentGalleryBinding, GalleryState, GalleryPresenter>(),
    GalleryView {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    val adapter: GalleryAdapter by lazy {
        GalleryAdapter(
            GalleryViewHolderCreator(
                Glide.with(this@GalleryFragment),
                presenter::onPhotoItemClick
            )
        )
    }

    override fun LayoutInflater.createBinding(container: ViewGroup?): FragmentGalleryBinding =
        FragmentGalleryBinding.inflate(this, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.app_name)
        with(binding) {
            findButton.setOnClickListener {
                presenter.onFindButtonClick()
            }
            recyclerView.layoutManager = GridLayoutManager(
                requireContext(), RECYCLER_VIEW_COLUMN_COUNT
            )
            recyclerView.adapter = adapter
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        binding.searchText.doOnTextChanged { text, _, _, _ -> presenter.onSearchTextChanged(text.toString()) }
    }

    override fun renderFindButton(isEnabled: Boolean) {
        binding.findButton.isEnabled = isEnabled
    }

    override fun renderList(list: PagedList<PhotoInfoItem>) {
        adapter.submitList(list)
    }

    override fun showErrorOccurred() {
        Toast.makeText(requireContext(), "Error occurred", Toast.LENGTH_SHORT).show()
    }
}