package com.izhenius.newsapiapp.data.network.api.news.mapper

import com.izhenius.newsapiapp.data.mapper.Mapper
import com.izhenius.newsapiapp.data.network.api.news.model.NetworkNewsArticle
import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.util.toDate

class NewsArticleMapper : Mapper<NetworkNewsArticle, NewsArticle> {

    override fun map(input: NetworkNewsArticle): NewsArticle {
        return NewsArticle(
            input.title.orEmpty(),
            input.description.orEmpty(),
            input.url,
            input.urlToImage.orEmpty(),
            input.publishedAt?.toDate(DATE_FORMAT_PATTERN)
        )
    }

    private companion object {
        const val DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    }
}