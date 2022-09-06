package com.example.newapp.ui.images

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newapp.App
import com.example.newapp.core.OnBackPressedListener
import com.example.newapp.databinding.FragmentImagesBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ImagesFragment: MvpAppCompatFragment(), ImagesView, OnBackPressedListener {

    private lateinit var viewBinding: FragmentImagesBinding
    private val presenter by moxyPresenter { ImagesPresenter(App.instance.router) }

    companion object {
        fun getInstance(): ImagesFragment {
            return ImagesFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentImagesBinding.inflate(inflater, container, false).also {
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