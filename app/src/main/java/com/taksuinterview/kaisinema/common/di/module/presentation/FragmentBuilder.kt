package com.taksuinterview.kaisinema.common.di.module.presentation

import com.taksuinterview.kaisinema.presentation.main.popular.Popular
import com.taksuinterview.kaisinema.presentation.main.popular.PopularMoviesFragment
import com.taksuinterview.kaisinema.presentation.main.popular.PopularMoviesPresenter
import com.taksuinterview.kaisinema.presentation.main.upcoming.Upcoming
import com.taksuinterview.kaisinema.presentation.main.upcoming.UpcomingMoviesFragment
import com.taksuinterview.kaisinema.presentation.main.upcoming.UpcomingMoviesPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract fun upcomingMoviesFragment(): UpcomingMoviesFragment

    @Binds
    abstract fun upcomingMoviesPresenter(upcomingMoviesPresenter: UpcomingMoviesPresenter<Upcoming.View>): Upcoming.Presenter<Upcoming.View>

    @ContributesAndroidInjector
    abstract fun popularMoviesFragment(): PopularMoviesFragment

    @Binds
    abstract fun popularMoviesPresenter(popularMoviesPresenter: PopularMoviesPresenter<Popular.View>): Popular.Presenter<Popular.View>

}
