package com.taksuinterview.kaisinema.common.util.framework

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.telephony.TelephonyManager
import androidx.core.os.ConfigurationCompat
import com.taksuinterview.kaisinema.common.di.qualifier.android.ApplicationContext
import java.util.*
import javax.inject.Inject


class DeviceUtilFactory @Inject internal constructor(@ApplicationContext private val context: Context) :
    DeviceUtil {

    override fun getConfigurationLocale(): Locale? =
        ConfigurationCompat.getLocales(context.resources.configuration).get(0)

    @SuppressWarnings("deprecation")
    override fun isOnline(): Boolean {
        var result = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }
                }
            }
        }

        return result
    }

    override fun isLocationEnabled(): Boolean {
        val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        var gpsEnabled = false
        var netWorkEnabled = false
        try {
            gpsEnabled = lm!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
            netWorkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return gpsEnabled && netWorkEnabled
    }

    override fun getUserCountryCode(): String {
        val placeHolderCountryCode = "ID"
        try {
            val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?
            if (tm != null) {
                val simCountry = tm.simCountryIso
                if (simCountry != null && simCountry.length == 2) {
                    return simCountry.uppercase(Locale.getDefault())
                } else if (tm.phoneType != TelephonyManager.PHONE_TYPE_CDMA) {
                    val networkCountry = tm.networkCountryIso
                    if (networkCountry != null && networkCountry.length == 2) {
                        return networkCountry.uppercase(Locale.getDefault())
                    }
                }
            } else {
                return placeHolderCountryCode
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

        return placeHolderCountryCode
    }
}