package com.izhenius.newsapiapp.data.network.api.news.mapper

import com.izhenius.newsapiapp.data.mapper.Mapper
import com.izhenius.newsapiapp.data.network.api.news.NewsApiData
import com.izhenius.newsapiapp.domain.error.ErrorEntity

class ErrorEntityMapper : Mapper<NewsApiData, ErrorEntity> {

    override fun map(input: NewsApiData): ErrorEntity {
        val errorMessage = "API error: ".plus(input.message ?: input.code ?: "Unknown")
        return when (input.code) {
            "400" -> ErrorEntity.Api.BadRequest(errorMessage)
            "401" -> ErrorEntity.Api.Unauthorized(errorMessage)
            "429" -> ErrorEntity.Api.TooManyRequests(errorMessage)
            else -> ErrorEntity.Api.ServerError(errorMessage)
        }
    }
}
