package com.taksuinterview.kaisinema.presentation.main.upcoming

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.taksuinterview.kaisinema.R
import com.taksuinterview.kaisinema.domain.result.MovieSum
import com.taksuinterview.kaisinema.presentation.base.BaseFragment
import com.taksuinterview.kaisinema.presentation.main.MovieListAdapter
import com.taksuinterview.kaisinema.presentation.moviedetail.MovieDetailActivity
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

class UpcomingMoviesFragment : BaseFragment(), Upcoming.View {
    @Inject
    lateinit var presenter: Upcoming.Presenter<Upcoming.View>
    lateinit var adapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this, this.lifecycle)
    }

    override fun showUpcomingMovies(movies: List<MovieSum>) {
        if (movies.isEmpty()) {
            rv_items.visibility = View.GONE
            empty_state.visibility = View.VISIBLE
        } else {
            adapter.setItems(movies.toMutableList())
            rv_items.adapter = adapter

            empty_state.visibility = View.GONE
            rv_items.visibility = View.VISIBLE
        }
    }

    override fun onPresenterAttached() {
        adapter = MovieListAdapter {
            startActivity(
                Intent(requireContext(), MovieDetailActivity::class.java)
                    .putExtra(MovieDetailActivity.EXTRA_MOVIE_ID, it.id)
            )
        }
        presenter.getUpcomingMovies(1)
    }

    override fun onConnectionChanged(isConnected: Boolean) {

    }

    override fun showMainProgressBar(show: Boolean) {
        shimmer_container.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoggedOut(hasLoggedOut: Boolean) {

    }
}
