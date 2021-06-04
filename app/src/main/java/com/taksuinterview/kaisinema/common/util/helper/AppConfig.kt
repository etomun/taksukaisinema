package com.taksuinterview.kaisinema.common.util.helper

import com.taksuinterview.kaisinema.common.util.state.ImageSize

interface AppConfig {
    fun getNotificationChannel(channelName: String?, importance: Int): String
    fun generatePosterUrl(path: String, size: ImageSize): String
    fun generateBackdropUrl(path: String, size: ImageSize): String
}