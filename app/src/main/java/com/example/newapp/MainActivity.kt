package com.example.newapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newapp.databinding.ActivityMainBinding

const val firstButtonPosition = 0
const val secondButtonPosition = 1
const val thirdButtonPosition = 2

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()

        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onFirstCounterClick()
            }
            btnNumber2.setOnClickListener {
                presenter.onSecondCounterClick()
            }
            btnNumber3.setOnClickListener {
                presenter.onThirdCounterClick()
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }


    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                firstButtonPosition -> tvText1.text = counter
                secondButtonPosition -> tvText2.text = counter
                thirdButtonPosition -> tvText3.text = counter
            }
        }

    }
}