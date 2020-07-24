package com.example.gallery.presentation.gallery.adapter

import androidx.recyclerview.widget.DiffUtil

class GalleryDiffUtilCallback : DiffUtil.ItemCallback<PhotoInfoItem>() {

    override fun areItemsTheSame(oldItem: PhotoInfoItem, newItem: PhotoInfoItem) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PhotoInfoItem, newItem: PhotoInfoItem) =
        oldItem == newItem
}