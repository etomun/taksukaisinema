package com.taksuinterview.kaisinema.presentation.main.upcoming

import com.taksuinterview.kaisinema.domain.result.MovieSum
import com.taksuinterview.kaisinema.presentation.base.Presentation

interface Upcoming {
    interface View : Presentation.View {
        fun showUpcomingMovies(movies: List<MovieSum>)
    }

    interface Presenter<V : View> : Presentation.Presenter<V> {
        fun getUpcomingMovies(page: Int)
    }
}