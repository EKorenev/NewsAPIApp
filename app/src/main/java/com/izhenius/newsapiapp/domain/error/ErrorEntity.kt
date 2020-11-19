package com.izhenius.newsapiapp.domain.error

sealed class ErrorEntity(override val message: String) : Throwable(message) {

    data class Network(override val message: String) : ErrorEntity(message)

    sealed class Api(override val message: String) : ErrorEntity(message) {
        data class BadRequest(override val message: String) : Api(message)
        data class Unauthorized(override val message: String) : Api(message)
        data class TooManyRequests(override val message: String) : Api(message)
        data class ServerError(override val message: String) : Api(message)
    }

    data class Unknown(override val message: String) : ErrorEntity(message)
}
