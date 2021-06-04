package com.taksuinterview.kaisinema.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.taksuinterview.kaisinema.presentation.main.popular.PopularMoviesFragment
import com.taksuinterview.kaisinema.presentation.main.upcoming.UpcomingMoviesFragment

class MainPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val count: Int
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = count

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UpcomingMoviesFragment()
            1 -> PopularMoviesFragment()
            else -> UpcomingMoviesFragment()
        }
    }
}