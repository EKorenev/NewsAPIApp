package com.izhenius.newsapiapp.domain.error

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorEntity
}
