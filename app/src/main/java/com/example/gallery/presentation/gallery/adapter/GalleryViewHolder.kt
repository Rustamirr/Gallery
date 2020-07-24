package com.example.gallery.presentation.gallery.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.gallery.databinding.FragmentGalleryItemBinding

private const val PHOTO_URL_FORMAT = "https://farm%s.staticflickr.com/%s/%s_%s.jpg"

class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // TODO: change to Glide.with(fragment)
    private val glideManager: RequestManager = Glide.with(itemView.context)
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
        itemView.setOnClickListener { TODO("presenter.onPhotoClick(item)") }
    }
}