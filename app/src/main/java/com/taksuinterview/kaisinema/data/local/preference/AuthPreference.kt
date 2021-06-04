package com.taksuinterview.kaisinema.data.local.preference

import android.content.Context
import com.taksuinterview.kaisinema.common.di.qualifier.android.ApplicationContext
import com.taksuinterview.kaisinema.common.di.scope.ApplicationScope
import com.taksuinterview.kaisinema.data.local.preference.AppPreference.AuthPref
import javax.inject.Inject

@ApplicationScope
class AuthPreference @Inject internal constructor(@ApplicationContext context: Context) :
    AppPreference(context), AuthPref {

    override fun getAuthToken(): String {
        return get(AUTH_TOKEN, "")
    }

    override fun setAuthToken(authToken: String) {
        set(AUTH_TOKEN, authToken)
    }

    override fun getUid(): Long {
        return get(UID, -1L)
    }

    override fun setUid(uid: Long) {
        set(UID, uid)
    }

    override fun getEmail(): String {
        return get(EMAIL, "")
    }

    override fun setEmail(email: String) {
        set(EMAIL, email)
    }

    override fun getName(): String {
        return get(NAME, "")
    }

    override fun setName(name: String) {
        set(NAME, name)
    }

    override fun getGender(): String {
        return get(GENDER, "")
    }

    override fun setGender(gender: String) {
        set(GENDER, gender)
    }

    override fun rememberEmail(email: String, password: String) {
        set(REMEMBERED_EMAIL, email)
        set(REMEMBERED_PASSWORD, password)
    }

    override fun getRememberEmail(): Pair<String, String> {
        return Pair(get(REMEMBERED_EMAIL, ""), get(REMEMBERED_PASSWORD, ""))
    }

    override fun clearRememberedEmail() {
        set(REMEMBERED_EMAIL, "")
        set(REMEMBERED_PASSWORD, "")
    }

    companion object {
        private const val AUTH_TOKEN = "bG86UjZadYNxUhI5mdxaDRJHNrsvM0tQ"
        private const val UID = "td5KqhRMRmVg63hj4ZYDSbFD9IbsENrP"
        private const val EMAIL = "RtLO3T1atAqhFq50dkRJ8ykCHc0zBxNy"
        private const val NAME = "ykCHc0zBAqhFq50dkRJ8xNyRtLO3T1at"
        private const val GENDER = "atAqhFqCHc8ykRtLO3T1BxNy0z50dkRJ"
        private const val REMEMBERED_EMAIL = "dkRaO3T1Hc8ykRtLNy0z50JBxtAqhFqC"
        private const val REMEMBERED_PASSWORD = "c8ykRJBxtAqhFqCtLNkRaO3T1Hy0z50d"
    }
}