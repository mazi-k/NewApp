package com.example.newapp.ui.user

import com.example.newapp.core.Screens
import com.example.newapp.model.GithubUser
import com.example.newapp.repository.GithubRepository
import com.github.terrakok.cicerone.Router

import moxy.MvpPresenter

class UserListPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showLoading()
        repository.getUsers().subscribe(
            {
                viewState.initList(it)
            }, {

            }
        )
        viewState.hideLoading()

    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun onItemChoose(user: GithubUser): Boolean {
        router.navigateTo(Screens.UserScreen)
        return true
    }
}
