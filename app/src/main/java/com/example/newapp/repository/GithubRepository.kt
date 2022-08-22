package com.example.newapp.repository

import com.example.newapp.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
}