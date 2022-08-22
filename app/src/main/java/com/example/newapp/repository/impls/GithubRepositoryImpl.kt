package com.example.newapp.repository.impls

import com.example.newapp.model.GithubUser
import com.example.newapp.repository.GithubRepository
import io.reactivex.rxjava3.core.Single

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("Alena87"),
        GithubUser("Lily34"),
        GithubUser("Combat"),
        GithubUser("MrDoctor"),
        GithubUser("Olly")
    )


    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }
    }
}
