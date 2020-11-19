package com.izhenius.newsapiapp.domain.model

import com.izhenius.newsapiapp.domain.error.ErrorEntity

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Failure(val error: ErrorEntity) : Result<Nothing>()
}
