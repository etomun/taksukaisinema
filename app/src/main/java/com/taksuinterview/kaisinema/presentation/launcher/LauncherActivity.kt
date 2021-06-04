package com.taksuinterview.kaisinema.presentation.launcher

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.taksuinterview.kaisinema.R
import com.taksuinterview.kaisinema.presentation.base.BaseActivity
import com.taksuinterview.kaisinema.presentation.main.MainActivity
import javax.inject.Inject

class LauncherActivity : BaseActivity(), Launcher.View {
    @Inject
    lateinit var presenter: Launcher.Presenter<Launcher.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        presenter.attachView(this, this.lifecycle)
    }

    override fun switchAuthStatus(isLogin: Boolean) {
//        if (isLogin) {
//            startActivity(Intent(this, MainActivity::class.java))
//        } else {
//            startActivity(Intent(this, LoginActivity::class.java))
//        }
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onPresenterAttached() {
        presenter.checkAuthStatus()
    }

    override fun onConnectionChanged(isConnected: Boolean) {

    }

    override fun showMainProgressBar(show: Boolean) {

    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoggedOut(hasLoggedOut: Boolean) {

    }
}
