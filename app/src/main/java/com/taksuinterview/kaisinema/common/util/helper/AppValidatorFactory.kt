package com.taksuinterview.kaisinema.common.util.helper

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern
import javax.inject.Inject

class AppValidatorFactory @Inject constructor() : AppValidator {
    override fun isUsernameValid(input: CharSequence): Boolean {
        val usernamePattern = "[A-Za-z][A-Za-z0-9_]{3,36}"
        return Pattern.compile(usernamePattern).matcher(input).matches()
    }

    override fun isEmailValid(input: CharSequence): Boolean {
        return !TextUtils.isEmpty(input) && Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }

    override fun isPasswordValid(input: CharSequence): Boolean {

        val passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,}\$"
        return Pattern.compile(passwordPattern).matcher(input).matches()
    }

    override fun isCurrencyValid(input: CharSequence): Boolean {
        return try {
            val trim = input.toString().replaceAfter(".", "").filter { it.isDigit() }.trim()
            val number = if (trim.isEmpty()) 0.0 else trim.toDouble()
            number > 0
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override fun isIndonesianPhoneValid(input: CharSequence): Boolean {
        val phonePattern = "\\+?([ -]?\\d+)+|\\(\\d+\\)([ -]\\d+)"
        val match = Pattern.compile(phonePattern).matcher(input).matches()
        /* couldn't add length constraint */
        return match && input.length > 9
    }
}