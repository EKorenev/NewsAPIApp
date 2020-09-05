package com.izhenius.newsapiapp.data.repository

import com.izhenius.newsapiapp.data.entity.NewsArticle

interface NewsRepository {
    suspend fun getListOfNews(pageSize: Int, page: Int): List<NewsArticle>
}