package com.example.newapp.ui.settings

import com.example.newapp.core.Screens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class SettingsPresenter(
    private val router: Router
) : MvpPresenter<SettingsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.SettingsScreen)
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}