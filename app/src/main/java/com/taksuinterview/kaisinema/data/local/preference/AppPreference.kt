package com.taksuinterview.kaisinema.data.local.preference

import android.content.Context
import com.taksuinterview.kaisinema.data.local.base.BasePreference

abstract class AppPreference protected constructor(context: Context) :
    BasePreference(context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)) {

    interface AuthPref {
        fun getAuthToken(): String
        fun setAuthToken(authToken: String)
        fun getUid(): Long
        fun setUid(uid: Long)
        fun getEmail(): String
        fun setEmail(email: String)
        fun getName(): String
        fun setName(name: String)
        fun getGender(): String
        fun setGender(gender: String)
        fun rememberEmail(email: String, password: String)
        fun getRememberEmail(): Pair<String, String>
        fun clearRememberedEmail()
    }

    companion object {
        private const val PREF_NAME =
            "hm3WRzK4CUI2RmXo8dw3meo2JviUMH3AHxcwT0Hkhz5UMCZ2sLthAYjqiYRfmXXJ"
    }
}