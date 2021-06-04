package com.taksuinterview.kaisinema.common.di.module.presentation

import com.taksuinterview.kaisinema.presentation.launcher.Launcher
import com.taksuinterview.kaisinema.presentation.launcher.LauncherActivity
import com.taksuinterview.kaisinema.presentation.launcher.LauncherPresenter
import com.taksuinterview.kaisinema.presentation.main.Main
import com.taksuinterview.kaisinema.presentation.main.MainActivity
import com.taksuinterview.kaisinema.presentation.main.MainPresenter
import com.taksuinterview.kaisinema.presentation.moviedetail.MovieDetail
import com.taksuinterview.kaisinema.presentation.moviedetail.MovieDetailActivity
import com.taksuinterview.kaisinema.presentation.moviedetail.MovieDetailPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun launcherActivity(): LauncherActivity

    @Binds
    abstract fun launcherPresenter(launcherPresenter: LauncherPresenter<Launcher.View>): Launcher.Presenter<Launcher.View>

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @Binds
    abstract fun mainPresenter(mainPresenter: MainPresenter<Main.View>): Main.Presenter<Main.View>

    @ContributesAndroidInjector
    abstract fun movieDetailActivity(): MovieDetailActivity

    @Binds
    abstract fun movieDetailPresenter(movieDetailPresenter: MovieDetailPresenter<MovieDetail.View>): MovieDetail.Presenter<MovieDetail.View>

}