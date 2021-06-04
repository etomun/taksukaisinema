package com.taksuinterview.kaisinema.common.util.helper

interface AppValidator {
    fun isUsernameValid(input: CharSequence): Boolean
    fun isEmailValid(input: CharSequence): Boolean
    fun isPasswordValid(input: CharSequence): Boolean
    fun isCurrencyValid(input: CharSequence): Boolean
    fun isIndonesianPhoneValid(input: CharSequence): Boolean
}