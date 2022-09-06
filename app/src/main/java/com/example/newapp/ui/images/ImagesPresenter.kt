package com.example.newapp.ui.images

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class ImagesPresenter(
    private val router: Router
) : MvpPresenter<ImagesView>() {

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}