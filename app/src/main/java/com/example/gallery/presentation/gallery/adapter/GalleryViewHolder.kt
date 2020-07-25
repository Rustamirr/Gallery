package com.example.gallery.presentation.gallery.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.gallery.databinding.FragmentGalleryItemBinding

private const val PHOTO_URL_FORMAT = "https://farm%s.staticflickr.com/%s/%s_%s.jpg"

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
        val res = when (item != null) {
            true -> PHOTO_URL_FORMAT.format(item.farmId, item.serverId, item.id, item.secret)
            else -> null
        }
        glideManager.load(res)
            .placeholder(android.R.drawable.ic_menu_help)
            .centerCrop()
            .into(binding.photo)
        if (item != null) {
            binding.root.setOnClickListener { onPhotoItemClick(item) }
        }
    }
}