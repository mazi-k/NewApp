package com.example.newapp.repository.impls

import com.example.newapp.model.GithubUser
import com.example.newapp.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("MrFox"),
        GithubUser("VictorMelnik"),
        GithubUser("Denix"),
        GithubUser("DmitryWb"),
        GithubUser("Larisa")
    )

    override fun getUsers(): List<GithubUser> {
        return repositories
    }
}
