package com.izhenius.newsapiapp.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.toDate(pattern: String, locale: Locale = Locale.US): Date? {
    val dateFormatter = SimpleDateFormat(pattern, locale)
    return try {
        dateFormatter.parse(this)
    } catch (e: ParseException) {
        null
    }
}

fun Date.toString(pattern: String, locale: Locale = Locale.US): String {
    val dateFormatter = SimpleDateFormat(pattern, locale)
    return dateFormatter.format(this)
}