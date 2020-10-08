package com.izhenius.newsapiapp.domain.repository

import com.izhenius.newsapiapp.domain.model.NewsArticle

interface NewsRepository {
    suspend fun getListOfNews(pageSize: Int, page: Int): List<NewsArticle>
}