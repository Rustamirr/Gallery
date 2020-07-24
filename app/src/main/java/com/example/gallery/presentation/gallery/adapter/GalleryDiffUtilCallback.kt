package com.example.gallery.presentation.gallery.adapter

import androidx.recyclerview.widget.DiffUtil

class GalleryDiffUtilCallback : DiffUtil.ItemCallback<PhotoItem>() {

    override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem) =
        oldItem == newItem
}