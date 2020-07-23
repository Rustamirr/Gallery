package com.example.gallery.data.gallery.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Url example: https://api.flickr.com/services/rest/?
 *
 *  method=flickr.photos.search&
 *
 *  media=photos&
 *
 *  format=json&
 *
 *  api_key=9905f5d6a51f154d5850cd6e9ea0af93&
 *
 *  per_page=20&
 *
 *  page=1&
 *
 *  text=Moscow&
 *
 *  nojsoncallback=1
 *
 * Photo url format: https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
 *
 * Photo url example: https://farm66.staticflickr.com/65535/50144413577_5479d0fda5.jpg
 */
interface GalleryNetworkApi {

    @GET("services/rest/?method=flickr.photos.search&media=photos&format=json&nojsoncallback=1")
    fun searchPhotosByText(
        @Query("api_key") apiKey: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
        @Query("text") searchText: String
    ): Single<SearchPhotosResponse>
}