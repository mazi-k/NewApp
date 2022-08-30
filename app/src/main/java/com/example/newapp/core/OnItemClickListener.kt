package com.example.newapp.core

import com.example.newapp.model.GithubUser

interface OnItemClickListener {
    fun onItemClick(user: GithubUser)
}