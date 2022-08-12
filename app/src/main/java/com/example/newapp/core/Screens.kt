package com.example.newapp.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.newapp.ui.user.UserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class Screens {
    object UsersScreen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return UserFragment.getInstance()
        }
    }

}