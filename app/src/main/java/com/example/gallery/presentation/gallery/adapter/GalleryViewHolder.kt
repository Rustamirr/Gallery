package com.example.gallery.presentation.gallery.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.gallery.databinding.FragmentGalleryItemBinding

class GalleryViewHolderCreator(
    private val glideManager: RequestManager,
    private val onPhotoItemClick: (photoInfoItem: PhotoInfoItem) -> Unit
) {
    fun createGalleryViewHolder(itemView: View): GalleryViewHolder =
        GalleryViewHolder(itemView, glideManager, onPhotoItemClick)
}

class GalleryViewHolder(
    itemView: View,
    private val glideManager: RequestManager,
    private val onPhotoItemClick: (photoInfoItem: PhotoInfoItem) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val binding = FragmentGalleryItemBinding.bind(itemView)

    fun bind(item: PhotoInfoItem?) {
        with(binding) {
            glideManager.load(item?.url)
                .placeholder(android.R.drawable.ic_menu_help)
                .centerCrop()
                .into(photo)
            when (item != null) {
                true -> root.setOnClickListener { onPhotoItemClick(item) }
                else -> root.setOnClickListener(null)
            }
        }
    }
}