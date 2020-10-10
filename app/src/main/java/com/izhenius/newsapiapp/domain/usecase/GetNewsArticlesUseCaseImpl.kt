package com.izhenius.newsapiapp.domain.usecase

import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.domain.repository.NewsRepository
import com.izhenius.newsapiapp.util.AppConstants

class GetNewsArticlesUseCaseImpl(
    private val newsRepository: NewsRepository
) : GetNewsArticlesUseCase {
    override suspend fun invoke(page: Int): List<NewsArticle> {
        return newsRepository.getListOfNews(AppConstants.NEWS_API_PAGE_SIZE, page)
    }
}
