package com.example.gallery.data.gallery.network

import com.example.gallery.domain.PhotoInfo
import io.reactivex.Observable
import javax.inject.Inject

private const val NETWORK_API_EXCEPTION = "Network api exception"
private const val API_KEY = "9905f5d6a51f154d5850cd6e9ea0af93"
private const val LIST_PAGE_SIZE = 20
private const val MAP_PAGE_SIZE = 20

class GalleryNetworkSourceImpl
@Inject constructor(
    private val networkApi: GalleryNetworkApi
) : GalleryNetworkSource {

    override fun searchPhotos(searchText: String, page: Int) =
        searchPhotos(searchText, page, LIST_PAGE_SIZE, 0)
            .map { requireNotNull(it.photosResponse).toPhotoInfo() }

    override fun searchPhotosGeo(searchText: String, page: Int): Observable<PhotoInfo> =
        searchPhotos(searchText, page, MAP_PAGE_SIZE, 1)
            .flatMapObservable { searchResponse ->
                Observable.fromIterable(requireNotNull(searchResponse.photosResponse).photoResponse)
            }
            .flatMapSingle(this::getPhotoLocation)

    private fun searchPhotos(searchText: String, page: Int, pageSize: Int, hasGeo: Int) =
        networkApi.searchPhotos(API_KEY, pageSize, searchText, page, hasGeo)
            .doOnSuccess {
                if (it.photosResponse == null) throw IllegalStateException(NETWORK_API_EXCEPTION)
            }

    private fun getPhotoLocation(photoResponse: PhotoResponse) =
        networkApi.getPhotoLocation(API_KEY, photoResponse.id)
            .map {
                val location = it.photoLocationResponse.locationResponse
                photoResponse.toPhotoInfo(location.latitude, location.longitude)
            }
}