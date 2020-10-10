package com.izhenius.newsapiapp.data.repository

import com.izhenius.newsapiapp.data.database.news.dao.NewsArticleDao
import com.izhenius.newsapiapp.data.mapper.ListMapper
import com.izhenius.newsapiapp.data.network.api.news.NewsApiService
import com.izhenius.newsapiapp.data.network.api.news.model.NetworkNewsArticle
import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepositoryImpl(
    private val newsApiService: NewsApiService,
    private val newsArticlesDao: NewsArticleDao,
    private val newsArticleListMapper: ListMapper<NetworkNewsArticle, NewsArticle>
) : NewsRepository {

    override suspend fun getListOfNews(pageSize: Int, page: Int): List<NewsArticle> {
        return withContext(Dispatchers.IO) {
            newsApiService.getListOfNews(pageSize, page)
                .articles
                .let {
                    newsArticleListMapper.map(it)
                }
        }
    }
}
