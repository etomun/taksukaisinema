package com.taksuinterview.kaisinema.presentation.base

import android.view.MenuItem
import com.taksuinterview.kaisinema.R


abstract class BaseChildActivity : BaseActivity() {
    override fun onStart() {
        super.onStart()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_circle_24dp)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}