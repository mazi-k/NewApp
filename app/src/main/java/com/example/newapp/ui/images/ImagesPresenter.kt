package com.example.newapp.ui.images

import com.example.newapp.core.Screens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class ImagesPresenter(
    private val router: Router
) : MvpPresenter<ImagesView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.ImagesScreen)
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}