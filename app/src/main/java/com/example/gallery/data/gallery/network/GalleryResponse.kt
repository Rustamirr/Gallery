package com.example.gallery.data.gallery.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchPhotosResponse(
    @Expose
    @SerializedName("photos")
    val photosResponse: PhotosResponse
)

data class PhotosResponse(
    @Expose
    @SerializedName("page")
    val page: Int,

    @Expose
    @SerializedName("pages")
    val pages: Int,

    @Expose
    @SerializedName("perpage")
    val perPage: Int,

    @Expose
    @SerializedName("photo")
    val photoResponse: List<PhotoResponse>,

    @Expose
    @SerializedName("total")
    val total: String
)

data class PhotoResponse(
    @Expose
    @SerializedName("farm")
    val farmId: Int,

    @Expose
    @SerializedName("id")
    val id: String,

    @Expose
    @SerializedName("isfamily")
    val isFamily: Int,

    @Expose
    @SerializedName("isfriend")
    val isFriend: Int,

    @Expose
    @SerializedName("ispublic")
    val isPublic: Int,

    @Expose
    @SerializedName("owner")
    val owner: String,

    @Expose
    @SerializedName("secret")
    val secret: String,

    @Expose
    @SerializedName("server")
    val serverId: String,

    @Expose
    @SerializedName("title")
    val title: String
)