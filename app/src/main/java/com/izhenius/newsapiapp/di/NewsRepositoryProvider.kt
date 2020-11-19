package com.izhenius.newsapiapp.di

import com.izhenius.newsapiapp.NewsApiApp
import com.izhenius.newsapiapp.data.mapper.ListMapperImpl
import com.izhenius.newsapiapp.data.network.ErrorHandlerImpl
import com.izhenius.newsapiapp.data.network.api.news.mapper.ErrorEntityMapper
import com.izhenius.newsapiapp.data.network.api.news.mapper.NewsArticleMapper
import com.izhenius.newsapiapp.data.network.api.news.mapper.ResultMapper
import com.izhenius.newsapiapp.data.repository.NewsRepositoryImpl
import com.izhenius.newsapiapp.util.AppConstants

object NewsRepositoryProvider {

    fun provideRepository() = NewsRepositoryImpl(
        NewsApiProvider.provideApi(
            NewsApiProvider.provideRetrofit(
                AppConstants.NEWS_API_BASE_URL,
                NewsApiProvider.provideConverterFactory(),
                NewsApiProvider.provideOkHttpClient()
            )
        ),
        NewsApiApp.newsDatabase.newsArticleDao(),
        ResultMapper(
            ListMapperImpl(NewsArticleMapper()),
            ErrorEntityMapper()
        ),
        ErrorHandlerImpl()
    )
}
