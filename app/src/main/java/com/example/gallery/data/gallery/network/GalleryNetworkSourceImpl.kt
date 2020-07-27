package com.example.gallery.data.gallery.network

import com.example.gallery.domain.PhotoInfo
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

private const val API_KEY = "9905f5d6a51f154d5850cd6e9ea0af93"
private const val PAGE_SIZE = 20

class GalleryNetworkSourceImpl
@Inject constructor(
    private val networkApi: GalleryNetworkApi
) : GalleryNetworkSource {

    override fun searchPhotos(searchText: String, page: Int) =
        networkApi.searchPhotos(API_KEY, PAGE_SIZE, searchText, page)
            .map(SearchPhotosResponse::toPhotoInfo)

    override fun searchPhotosGeo(searchText: String, page: Int): Single<List<PhotoInfo>> =
        networkApi.searchPhotos(API_KEY, PAGE_SIZE, searchText, page)
            .map(SearchPhotosResponse::toPhotoInfo)
            .flatMapObservable {
                Observable.fromIterable(it)
            }
            .flatMapSingle {
                networkApi.getPhotoLocation(API_KEY, it.id)
                    .map {
                        photoResponse.toPhotoInfo(it)
                    }
            }
            .toList()
            .map { it.filter { photoInfo -> photoInfo.latitude != null } }

    //Single.just(listOf(PhotoInfo("1", "Test", "", -34.0, 151.0)))

}