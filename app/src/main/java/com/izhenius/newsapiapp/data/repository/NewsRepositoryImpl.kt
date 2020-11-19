package com.izhenius.newsapiapp.data.repository

import com.izhenius.newsapiapp.data.database.news.dao.NewsArticleDao
import com.izhenius.newsapiapp.data.mapper.Mapper
import com.izhenius.newsapiapp.data.network.api.news.NewsApiData
import com.izhenius.newsapiapp.data.network.api.news.NewsApiService
import com.izhenius.newsapiapp.data.network.safeNetworkCall
import com.izhenius.newsapiapp.domain.error.ErrorHandler
import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.domain.model.Result
import com.izhenius.newsapiapp.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers

class NewsRepositoryImpl(
    private val newsApiService: NewsApiService,
    private val newsArticlesDao: NewsArticleDao,
    private val resultMapper: Mapper<NewsApiData, Result<List<NewsArticle>>>,
    private val errorHandler: ErrorHandler
) : NewsRepository {

    override suspend fun getListOfNews(pageSize: Int, page: Int): Result<List<NewsArticle>> {
        return safeNetworkCall(
            Dispatchers.IO,
            { newsApiService.getListOfNews(pageSize, page) },
            resultMapper,
            errorHandler
        )
    }
}
