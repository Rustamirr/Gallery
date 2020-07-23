package com.example.gallery.presentation.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.gallery.R

class GalleryAdapter : ListAdapter<GalleryItem, GalleryViewHolder>(GalleryDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GalleryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_gallery_item, parent, false)
        )

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}