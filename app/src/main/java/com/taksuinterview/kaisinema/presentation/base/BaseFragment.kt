package com.taksuinterview.kaisinema.presentation.base

import android.content.Context
import android.view.inputmethod.InputMethodManager
import dagger.android.support.DaggerFragment


abstract class BaseFragment : DaggerFragment(), Presentation.View {
    fun hideSoftKeyboard() {
        val imm: InputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}