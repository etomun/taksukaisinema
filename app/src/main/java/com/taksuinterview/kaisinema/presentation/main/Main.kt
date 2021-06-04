package com.taksuinterview.kaisinema.presentation.main

import com.taksuinterview.kaisinema.presentation.base.Presentation

interface Main {
    interface View : Presentation.View

    interface Presenter<V : View> : Presentation.Presenter<V> {
        fun getMovieGenres()
    }
}