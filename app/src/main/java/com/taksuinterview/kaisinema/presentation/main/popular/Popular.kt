package com.taksuinterview.kaisinema.presentation.main.popular

import com.taksuinterview.kaisinema.domain.result.MovieSum
import com.taksuinterview.kaisinema.presentation.base.Presentation

interface Popular {
    interface View : Presentation.View {
        fun showPopularMovies(movies: List<MovieSum>)
    }

    interface Presenter<V : View> : Presentation.Presenter<V> {
        fun getUpcomingMovies(page: Int)
    }
}