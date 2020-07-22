package com.example.gallery.domain.core

import timber.log.Timber

private const val UNEXPECTED_ERROR = "Unexpected Error"

class ErrorUtils {

    fun logError(throwable: Throwable) {
        Timber.e(throwable, UNEXPECTED_ERROR)
    }
}