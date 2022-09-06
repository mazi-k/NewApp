package com.example.newapp.ui.settings

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class SettingsPresenter(
    private val router: Router
) : MvpPresenter<SettingsView>() {

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}