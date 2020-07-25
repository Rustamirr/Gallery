package com.example.gallery.presentation.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.gallery.R

class GalleryAdapter(
    private val galleryViewHolderCreator: GalleryViewHolderCreator
) : PagedListAdapter<PhotoInfoItem, GalleryViewHolder>(GalleryDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        galleryViewHolderCreator.createGalleryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_gallery_item, parent, false)
        )

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}