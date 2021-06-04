package com.taksuinterview.kaisinema.presentation.launcher

import com.taksuinterview.kaisinema.presentation.base.Presentation

interface Launcher {
    interface View : Presentation.View {
        fun switchAuthStatus(isLogin: Boolean)
    }

    interface Presenter<V : View> : Presentation.Presenter<V> {
        fun checkAuthStatus()
    }
}