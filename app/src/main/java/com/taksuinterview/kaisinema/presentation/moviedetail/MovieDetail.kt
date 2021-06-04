package com.taksuinterview.kaisinema.presentation.moviedetail

import com.taksuinterview.kaisinema.domain.result.Movie
import com.taksuinterview.kaisinema.presentation.base.Presentation

interface MovieDetail {
    interface View : Presentation.View {
        fun showDetail(movie: Movie)
    }

    interface Presenter<V : View> : Presentation.Presenter<V> {
        fun getMovieDetail(movieId: Long)
    }
}