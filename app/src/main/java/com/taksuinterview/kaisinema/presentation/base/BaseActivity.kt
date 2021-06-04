package com.taksuinterview.kaisinema.presentation.base

import android.content.Context
import android.view.inputmethod.InputMethodManager
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(), Presentation.View {
    fun hideSoftKeyboard() {
        val imm: InputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}