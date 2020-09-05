package com.izhenius.newsapiapp.data.repository

import com.izhenius.newsapiapp.data.network.api.NewsProvider

private const val BASE_URL = "https://newsapi.org"

fun provideNewsRepository(): NewsRepository {
    return NewsRepositoryRemote(
        NewsProvider.provideApi(
            NewsProvider.provideRetrofit(
                BASE_URL,
                NewsProvider.provideConverterFactory(),
                NewsProvider.provideOkHttpClient()
            )
        )
    )
}