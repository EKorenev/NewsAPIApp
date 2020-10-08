package com.izhenius.newsapiapp.data.network.api.news

import com.izhenius.newsapiapp.data.network.api.news.model.NetworkNewsArticle
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsApiData(
    @Json(name = "status") val status: String,
    @Json(name = "articles") val articles: List<NetworkNewsArticle>
)