package com.izhenius.newsapiapp.domain.usecase

import com.izhenius.newsapiapp.domain.model.NewsArticle

interface GetNewsArticlesUseCase {
    suspend operator fun invoke(page: Int): List<NewsArticle>
}
