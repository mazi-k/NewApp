package com.example.newapp.ui.user

import com.example.newapp.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserListView : MvpView {
    fun initList(list: List<GithubUser>)
}
