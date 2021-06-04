package com.taksuinterview.kaisinema.common.util.helper

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.graphics.Point
import android.net.Uri
import android.view.View
import com.taksuinterview.kaisinema.common.di.qualifier.android.ApplicationContext
import java.io.ByteArrayOutputStream
import java.io.IOException
import javax.inject.Inject
import kotlin.math.*

class UIHelperFactory @Inject constructor(@ApplicationContext private val context: Context) :
    UIHelper {
    override fun getCenterPointOfView(view: View?): Point? {
        val cx = (view!!.left + view.right) / 2
        val cy = (view.top + view.bottom) / 2
        return Point(cx, cy)
    }

    override fun getCircleRadiusOfView(view: View?): Float {
        // get the center for the clipping circle
        // get the center for the clipping circle
        val cx = (view!!.left + view.right) / 2
        val cy = (view.top + view.bottom) / 2

        // get the final radius for the clipping circle
        // get the final radius for the clipping circle
        val dx = max(cx, view.width - cx)
        val dy = max(cy, view.height - cy)
        return hypot(dx.toDouble(), dy.toDouble()).toFloat()
    }

    override fun getResId(resName: String?, c: Class<*>): Int {
        return try {
            val idField = c.getDeclaredField(resName!!)
            idField.getInt(idField)
        } catch (e: Exception) {
            e.printStackTrace()
            -1
        }
    }

    override fun getRawId(resName: String): Int {
        val fileName = resName.substring(6)
        return context.resources.getIdentifier(fileName, "raw", context.packageName)
    }
}