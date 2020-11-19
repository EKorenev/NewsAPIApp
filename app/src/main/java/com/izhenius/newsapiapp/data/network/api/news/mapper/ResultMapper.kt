package com.izhenius.newsapiapp.data.network.api.news.mapper

import com.izhenius.newsapiapp.data.mapper.ListMapper
import com.izhenius.newsapiapp.data.mapper.Mapper
import com.izhenius.newsapiapp.data.network.api.news.NewsApiData
import com.izhenius.newsapiapp.data.network.api.news.model.NetworkNewsArticle
import com.izhenius.newsapiapp.domain.error.ErrorEntity
import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.domain.model.Result

class ResultMapper(
    private val newsArticleListMapper: ListMapper<NetworkNewsArticle, NewsArticle>,
    private val errorEntityMapper: Mapper<NewsApiData, ErrorEntity>
) : Mapper<NewsApiData, Result<List<NewsArticle>>> {

    override fun map(input: NewsApiData): Result<List<NewsArticle>> {
        return when (input.status) {
            "ok" -> Result.Success(newsArticleListMapper.map(input.articles))
            else -> Result.Failure(errorEntityMapper.map(input))
        }
    }
}
