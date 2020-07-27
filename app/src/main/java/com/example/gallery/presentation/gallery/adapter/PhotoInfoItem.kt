package com.example.gallery.presentation.gallery.adapter

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoInfoItem(
    val id: String,
    val title: String,
    val url: String
) : Parcelable