package com.example.newapp

class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onFirstCounterClick() {
        val newValue = model.next(firstButtonPosition)
        view.setText(newValue.toString(), firstButtonPosition)
    }

    fun onSecondCounterClick() {
        val newValue = model.next(secondButtonPosition)
        view.setText(newValue.toString(), secondButtonPosition)
    }

    fun onThirdCounterClick() {
        val newValue = model.next(thirdButtonPosition)
        view.setText(newValue.toString(), thirdButtonPosition)
    }
}
