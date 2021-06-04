package com.taksuinterview.kaisinema.presentation.main

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.taksuinterview.kaisinema.R
import com.taksuinterview.kaisinema.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), Main.View {
    @Inject
    lateinit var presenter: Main.Presenter<Main.View>

    private lateinit var adapter: MainPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this, this.lifecycle)
    }

    override fun onPresenterAttached() {
        presenter.getMovieGenres()
        val titles = arrayOf(getString(R.string.title_upcoming), getString(R.string.title_popular))
        adapter = MainPagerAdapter(supportFragmentManager, this.lifecycle, titles.size)
        view_pager.adapter = adapter
        TabLayoutMediator(tabs, view_pager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    override fun onConnectionChanged(isConnected: Boolean) {

    }

    override fun showMainProgressBar(show: Boolean) {

    }

    override fun showError(message: String?) {
        message?.let { Snackbar.make(root, it, Snackbar.LENGTH_SHORT).show() }
    }

    override fun onLoggedOut(hasLoggedOut: Boolean) {

    }
}
