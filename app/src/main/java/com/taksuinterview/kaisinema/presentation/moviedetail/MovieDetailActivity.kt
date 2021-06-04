package com.taksuinterview.kaisinema.presentation.moviedetail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.snackbar.Snackbar
import com.taksuinterview.kaisinema.R
import com.taksuinterview.kaisinema.domain.result.Movie
import com.taksuinterview.kaisinema.presentation.base.BaseActivity
import custom.view.behavior.AppBarScrollWatcher
import kotlinx.android.synthetic.main.activity_movie_detail.*
import javax.inject.Inject

class MovieDetailActivity : BaseActivity(), MovieDetail.View {
    @Inject
    lateinit var presenter: MovieDetail.Presenter<MovieDetail.View>

    private lateinit var appBarScrollListener: AppBarScrollWatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        presenter.attachView(this, this.lifecycle)
    }

    override fun showDetail(movie: Movie) {
        Glide.with(applicationContext).load(movie.backdropSmall)
            .thumbnail(0.5f)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(iv_banner)

        Glide.with(applicationContext).load(movie.posterSmall)
            .thumbnail(0.5f)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(iv_poster)

        tv_title.text = movie.title
        tv_title_1.text = movie.title
        tv_release_date.text = movie.releaseDate
        tv_rating.text = movie.voteAverage.toString()
        tv_vote_count.text = getString(R.string.label_dynamic_votes, movie.voteCount)
        tv_synopsys.text = movie.overview

        var genres = ""
        movie.genres.map {
            genres = "$genres, "
            genres = "$genres ${it.name}"
        }
        genres = genres.replaceFirst(", ", "")
        tv_genre.text = genres.trim()
    }

    override fun onPresenterAttached() {
        back.setOnClickListener { onBackPressed() }
        appBarScrollListener =
            AppBarScrollWatcher { _, _, argbZeroOnExpanded, argbZeroOnCollapsed, _, _ ->
                tv_title.setTextColor(
                    Color.argb(
                        argbZeroOnExpanded,
                        argbZeroOnCollapsed,
                        argbZeroOnCollapsed,
                        argbZeroOnCollapsed
                    )
                )
                tv_title_1.setTextColor(
                    Color.argb(
                        argbZeroOnCollapsed,
                        argbZeroOnExpanded,
                        argbZeroOnExpanded,
                        argbZeroOnExpanded
                    )
                )
            }
        app_bar.addOnOffsetChangedListener(appBarScrollListener)

        val movieId = intent.getLongExtra(EXTRA_MOVIE_ID, 0)
        presenter.getMovieDetail(movieId)
    }

    override fun onConnectionChanged(isConnected: Boolean) {

    }

    override fun showMainProgressBar(show: Boolean) {
        shimmer_container.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
        message?.let { Snackbar.make(root, it, Snackbar.LENGTH_SHORT).show() }
    }

    override fun onLoggedOut(hasLoggedOut: Boolean) {

    }

    companion object {
        const val EXTRA_MOVIE_ID = "ylsOjo7M9efCFsiCiaAka2zhfqAfEHYn"
    }
}
