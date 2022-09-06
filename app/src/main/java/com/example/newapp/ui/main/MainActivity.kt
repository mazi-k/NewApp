package com.example.newapp.ui.main

import android.os.Bundle
import com.example.newapp.App
import com.example.newapp.R
import com.example.newapp.core.OnBackPressedListener
import com.example.newapp.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.container)
    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { MainPresenter(App.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setupNavigation()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.instance.navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is OnBackPressedListener && currentFragment.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()
    }

    private fun setupNavigation() {
        binding.bottomNavigationView.selectedItemId = R.id.action_bottom_view_home
    }

    private fun init() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_bottom_view_home -> {
                    presenter.onHomeScreen()
                    true
                }
                R.id.action_bottom_view_settings -> {
                    presenter.onSettingsScreen()
                    true
                }
                R.id.action_bottom_view_images -> {
                    presenter.onImagesScreen()
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

}
