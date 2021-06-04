package com.taksuinterview.kaisinema.common.util.helper

import java.util.*

interface DataConverter {
    fun hashMD5(input: String): String
    fun formatCurrency(numb: Double, locale: Currency): CharSequence
    fun formatDate(timeMillis: Long, pattern: String): String
}