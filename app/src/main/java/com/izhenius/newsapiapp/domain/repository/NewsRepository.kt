package com.izhenius.newsapiapp.domain.repository

import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.domain.model.Result

interface NewsRepository {
    suspend fun getListOfNews(pageSize: Int, page: Int): Result<List<NewsArticle>>
}
