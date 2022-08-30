package com.example.newapp.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.newapp.GITHUB_USER
import com.example.newapp.ui.user.UserFragment
import com.example.newapp.ui.user.UserListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class Screens {
    object UsersScreen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return UserListFragment.getInstance()
        }
    }

    data class UserScreen(val id: String) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return UserFragment.getInstance(Bundle().apply {
                putString(GITHUB_USER, id)
            })
        }
    }
}