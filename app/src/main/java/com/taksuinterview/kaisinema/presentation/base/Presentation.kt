package com.taksuinterview.kaisinema.presentation.base

import androidx.lifecycle.Lifecycle
import io.reactivex.disposables.Disposable

interface Presentation {
    interface View {
        fun onPresenterAttached()
        fun onConnectionChanged(isConnected: Boolean)
        fun showMainProgressBar(show: Boolean)
        fun showError(message: String?)
        fun onLoggedOut(hasLoggedOut: Boolean)
    }

    interface Presenter<V : View> {
        fun isLogin(): Boolean
        fun logout()
        fun attachView(view: V, lifecycle: Lifecycle)
        fun detachView()
        fun enqueue(disposable: Disposable)
    }
}