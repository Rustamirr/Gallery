package com.example.gallery.presentation.navigation

import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen : SupportAppScreen() {

    /*data class LoginSms(private val phone: String) : Screen() {
        override fun getFragment() = LoginSmsFragment.getInstance(phone)
    }*/
}
