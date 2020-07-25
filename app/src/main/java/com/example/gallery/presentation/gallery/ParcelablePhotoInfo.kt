package com.example.gallery.presentation.gallery

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParcelablePhotoInfo(
    val id: String,
    val title: String,
    val url: String
) : Parcelable