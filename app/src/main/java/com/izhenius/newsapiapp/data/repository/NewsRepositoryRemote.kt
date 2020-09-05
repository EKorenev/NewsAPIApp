package com.izhenius.newsapiapp.data.repository

import com.izhenius.newsapiapp.data.entity.NewsArticle
import com.izhenius.newsapiapp.data.network.api.NewsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepositoryRemote(private val api: NewsApi) : NewsRepository {
    override suspend fun getListOfNews(pageSize: Int, page: Int): List<NewsArticle> {
        return withContext(Dispatchers.IO) {
            api.getListOfNews(pageSize, page)
                .articles
                .map { article ->
                    NewsArticle(
                        article.title,
                        article.description,
                        article.url,
                        article.urlToImage,
                        article.publishedAt
                    )
                }
        }
    }
}