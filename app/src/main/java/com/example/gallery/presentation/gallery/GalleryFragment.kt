package com.example.gallery.presentation.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gallery.databinding.FragmentGalleryBinding
import com.example.gallery.domain.gallery.GalleryState
import com.example.gallery.presentation.core.BaseFragment
import com.example.gallery.presentation.gallery.adapter.GalleryAdapter
import com.example.gallery.presentation.gallery.adapter.PagedDelegate
import com.example.gallery.presentation.gallery.adapter.PhotoInfoItem

private const val GRID_PHOTO_COLUMNS = 4

class GalleryFragment : BaseFragment<FragmentGalleryBinding, GalleryState, GalleryPresenter>(),
    GalleryView {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private val adapter = GalleryAdapter()
    private val pagedDelegate = PagedDelegate()

    override fun LayoutInflater.createBinding(container: ViewGroup?): FragmentGalleryBinding =
        FragmentGalleryBinding.inflate(this, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            findButton.setOnClickListener {
                pagedDelegate.observePagedList()
                    .observe(
                        viewLifecycleOwner,
                        Observer(adapter::submitList)
                    )
                //presenter.onFindButtonClick(searchText.text.toString())
            }
            recyclerView.layoutManager = GridLayoutManager(requireContext(), GRID_PHOTO_COLUMNS)
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

    override fun renderList(list: List<PhotoInfoItem>) {
        pagedDelegate.list = list
    }

    override fun showErrorOccurred() {
        Toast.makeText(requireContext(), "Error occurred", Toast.LENGTH_SHORT).show()
    }
}