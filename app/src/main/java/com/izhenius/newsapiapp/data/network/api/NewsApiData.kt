package com.izhenius.newsapiapp.data.network.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsApiData(
    @Json(name = "status") val status: String,
    @Json(name = "articles") val articles: List<Article>
)

@JsonClass(generateAdapter = true)
data class Article(
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "url") val url: String?,
    @Json(name = "urlToImage") val urlToImage: String?,
    @Json(name = "publishedAt") val publishedAt: String?
)