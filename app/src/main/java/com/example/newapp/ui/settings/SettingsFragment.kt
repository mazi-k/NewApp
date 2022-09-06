package com.example.newapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newapp.App
import com.example.newapp.core.OnBackPressedListener
import com.example.newapp.databinding.FragmentSettingsBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SettingsFragment: MvpAppCompatFragment(), SettingsView, OnBackPressedListener {

    private lateinit var viewBinding: FragmentSettingsBinding
    private val presenter by moxyPresenter { SettingsPresenter(App.instance.router) }

    companion object {
        fun getInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSettingsBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
        }
    }


    override fun onBackPressed() = presenter.onBackPressed()
}