package com.example.gallery.presentation.core

import androidx.annotation.CallSuper
import com.example.gallery.domain.core.Interactor
import com.example.gallery.domain.core.Schedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

abstract class BasePresenter<S, V : BaseView, I : Interactor<S>>(
    protected val router: Router,
    protected val interactor: I,
    protected val schedulers: Schedulers
) : MvpPresenter<V>() {

    private val compositeDisposable = CompositeDisposable()

    @CallSuper
    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    protected fun disposeOnDestroy(vararg disposables: Disposable) {
        disposables.forEach(compositeDisposable::plusAssign)
    }
}
