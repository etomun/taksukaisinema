package com.taksuinterview.kaisinema.common.util.framework

import java.util.*

interface DeviceUtil {
    fun getConfigurationLocale(): Locale?
    fun isOnline(): Boolean
    fun isLocationEnabled(): Boolean
    fun getUserCountryCode(): String
}