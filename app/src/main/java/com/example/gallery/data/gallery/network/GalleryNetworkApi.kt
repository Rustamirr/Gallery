package com.example.gallery.data.gallery.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

// Example
// https://api.flickr.com/services/rest/?method=flickr.photos.search&media=photos&format=json&api_key=9905f5d6a51f154d5850cd6e9ea0af93&per_page=20&page=1&text=Moscow&nojsoncallback=1
// https://api.flickr.com/services/rest/?method=flickr.photos.geo.getLocation&format=json&api_key=9905f5d6a51f154d5850cd6e9ea0af93&nojsoncallback=1&photo_id=50154410021
interface GalleryNetworkApi {

    @GET("services/rest/?method=flickr.photos.search&media=photos&format=json&nojsoncallback=1")
    fun searchPhotos(
        @Query("api_key") apiKey: String,
        @Query("per_page") perPage: Int,
        @Query("text") searchText: String,
        @Query("page") page: Int,
        @Query("has_geo") hasGeo: Int
    ): Single<SearchPhotosResponse>

    @GET("services/rest/?method=flickr.photos.geo.getLocation&format=json&nojsoncallback=1")
    fun getPhotoLocation(
        @Query("api_key") apiKey: String,
        @Query("photo_id") photoId: String
    ): Single<GetPhotoLocationResponse>
}

