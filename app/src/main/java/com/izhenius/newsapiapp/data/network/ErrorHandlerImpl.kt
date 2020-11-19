package com.izhenius.newsapiapp.data.network

import com.izhenius.newsapiapp.domain.error.ErrorEntity
import com.izhenius.newsapiapp.domain.error.ErrorHandler
import java.io.IOException

class ErrorHandlerImpl : ErrorHandler {

    override fun getError(throwable: Throwable): ErrorEntity {
        val errorMessage = throwable.message ?: "Unknown"
        return when (throwable) {
            is IOException -> ErrorEntity.Network(errorMessage)
            else -> ErrorEntity.Unknown(errorMessage)
        }
    }
}
