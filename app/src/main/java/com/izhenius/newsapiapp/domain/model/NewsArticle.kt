package com.izhenius.newsapiapp.domain.model

import java.util.Date

data class NewsArticle(
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: Date?
)
