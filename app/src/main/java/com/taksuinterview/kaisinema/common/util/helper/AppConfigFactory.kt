package com.taksuinterview.kaisinema.common.util.helper

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import com.taksuinterview.kaisinema.BuildConfig
import com.taksuinterview.kaisinema.common.di.qualifier.android.ApplicationContext
import com.taksuinterview.kaisinema.common.util.constant.ImageSizeUrl
import com.taksuinterview.kaisinema.common.util.state.ImageSize
import java.util.*
import javax.inject.Inject

class AppConfigFactory @Inject internal constructor(@ApplicationContext private val context: Context) :
    AppConfig {

    override fun getNotificationChannel(channelName: String?, importance: Int): String {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return ""
        }
        val chan = NotificationChannel(channelName, channelName, importance)
        chan.lightColor = Color.WHITE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        chan.enableVibration(true)
        chan.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        val service = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (service.getNotificationChannel(channelName) == null) {
            service.createNotificationChannel(chan)
        }
        return channelName!!
    }

    override fun generatePosterUrl(path: String, size: ImageSize): String {
        val baseUrl = BuildConfig.IMAGE_URL
        return when(size) {
            ImageSize.LARGE -> baseUrl + ImageSizeUrl.W780 + path
            ImageSize.ORIGINAL -> baseUrl + ImageSizeUrl.ORIGINAL + path
            ImageSize.SMALL -> baseUrl + ImageSizeUrl.W185 + path
        }
    }

    override fun generateBackdropUrl(path: String, size: ImageSize): String {
        val baseUrl = BuildConfig.IMAGE_URL
        return when(size) {
            ImageSize.LARGE -> baseUrl + ImageSizeUrl.W1280 + path
            ImageSize.ORIGINAL -> baseUrl + ImageSizeUrl.ORIGINAL + path
            ImageSize.SMALL -> baseUrl + ImageSizeUrl.W300 + path
        }
    }
}