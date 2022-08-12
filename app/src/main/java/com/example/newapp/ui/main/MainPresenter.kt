package com.example.newapp.ui.main

import com.example.newapp.core.Screens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }
}
