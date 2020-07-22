package com.example.gallery.presentation.mainactivity

import com.example.gallery.presentation.navigation.Screen
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter
@Inject constructor(
    private val router: Router
) : MvpPresenter<MainActivityView>() {

    private fun navigateToStartScreen() {
        router.navigateTo(Screen.Gallery)
    }
}