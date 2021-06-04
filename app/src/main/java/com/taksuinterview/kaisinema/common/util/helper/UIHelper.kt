package com.taksuinterview.kaisinema.common.util.helper

import android.graphics.Point
import android.net.Uri
import android.view.View
import java.io.ByteArrayOutputStream

interface UIHelper {
    fun getCenterPointOfView(view: View?): Point?
    fun getCircleRadiusOfView(view: View?): Float
    fun getResId(resName: String?, c: Class<*>): Int
    fun getRawId(resName: String): Int
}