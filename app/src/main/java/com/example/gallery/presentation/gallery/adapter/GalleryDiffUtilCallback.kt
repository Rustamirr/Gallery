package com.example.gallery.presentation.gallery.adapter

import androidx.recyclerview.widget.DiffUtil

class GalleryDiffUtilCallback : DiffUtil.ItemCallback<GalleryItem>() {

    override fun areItemsTheSame(oldItem: GalleryItem, newItem: GalleryItem) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GalleryItem, newItem: GalleryItem) =
        oldItem == newItem
}