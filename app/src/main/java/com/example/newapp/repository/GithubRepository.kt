package com.example.newapp.repository

import com.example.newapp.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
}