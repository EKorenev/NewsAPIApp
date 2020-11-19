package com.izhenius.newsapiapp.domain.usecase

import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.domain.model.Result

interface GetNewsArticlesUseCase {
    suspend operator fun invoke(page: Int): Result<List<NewsArticle>>
}
