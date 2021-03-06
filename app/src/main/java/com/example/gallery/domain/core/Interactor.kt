package com.example.gallery.domain.core

import io.reactivex.Observable

interface Interactor<S> {

    fun observeState(): Observable<S>
}