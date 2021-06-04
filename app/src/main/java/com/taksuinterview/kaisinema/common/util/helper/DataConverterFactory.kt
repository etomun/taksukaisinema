package com.taksuinterview.kaisinema.common.util.helper

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DataConverterFactory @Inject constructor() :
    DataConverter {
    override fun hashMD5(input: String): String {
        return try {
            val md = MessageDigest.getInstance("MD5")
            val messageDigest = md.digest(input.toByteArray())
            val no = BigInteger(1, messageDigest)
            val hashText = StringBuilder(no.toString(16))
            while (hashText.length < 32) {
                hashText.insert(0, "0")
            }
            hashText.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }

    override fun formatCurrency(numb: Double, locale: Currency): CharSequence {
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = locale
        return format.format(numb)
    }

    override fun formatDate(timeMillis: Long, pattern: String): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(timeMillis)
    }
}