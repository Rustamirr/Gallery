package com.example.gallery.data.gallery.network

import com.example.gallery.domain.PhotoInfo

private const val PHOTO_URL_FORMAT = "https://farm%s.staticflickr.com/%s/%s_%s.jpg"
private const val NETWORK_API_EXCEPTION = "Network api exception"
private const val LATITUDE_LONGITUDE_PARSE_EXCEPTION =
    "NumberFormatException: latitude/longitude string to double"

fun SearchPhotosResponse.toPhotoInfo(): List<PhotoInfo> {
    if (photosResponse == null) throw IllegalStateException(NETWORK_API_EXCEPTION)
    return photosResponse.photoResponse
        .map { it.toPhotoInfo(null, null) }
}

fun PhotoResponse.toPhotoInfo(locationResponse: GetPhotoLocationResponse) =
    when (locationResponse.photoLocationResponse) {
        null -> toPhotoInfo(null, null)
        else -> locationResponse.photoLocationResponse.locationResponse.run {
            toPhotoInfo(latitude, longitude)
        }
    }

private fun PhotoResponse.toPhotoInfo(latitude: String?, longitude: String?): PhotoInfo {
    val dLatitude: Double?
    val dLongitude: Double?
    try {
        dLatitude = latitude?.toDouble()
        dLongitude = longitude?.toDouble()
    } catch (e: NumberFormatException) {
        throw IllegalStateException(LATITUDE_LONGITUDE_PARSE_EXCEPTION)
    }
    return PhotoInfo(
        id, title, PHOTO_URL_FORMAT.format(farmId, serverId, id, secret), dLatitude, dLongitude
    )
}