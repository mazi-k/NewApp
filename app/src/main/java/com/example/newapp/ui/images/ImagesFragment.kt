package com.example.newapp.ui.images

import android.R
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newapp.App
import com.example.newapp.GALERY_REQEST_CODE
import com.example.newapp.core.OnBackPressedListener
import com.example.newapp.databinding.FragmentImagesBinding
import moxy.MvpAppCompatActivity
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
            addImageButton.setOnClickListener {
                addImage()
            }

            saveImageButton.setOnClickListener {
                saveImage()
            }
        }


    }

    private fun addImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, GALERY_REQEST_CODE)
    }


    private fun saveImage() {
        val bInt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(bInt, GALERY_REQEST_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == GALERY_REQEST_CODE && resultCode == RESULT_OK){
            val image = data?.data
            viewBinding.downloadedImage.setImageURI(image)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()
}