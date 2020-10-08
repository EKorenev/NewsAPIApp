package com.izhenius.newsapiapp.data.network.api.news

import com.izhenius.newsapiapp.util.AppConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("/v2/everything?$GET_REQUEST_PARAMETERS")
    suspend fun getListOfNews(
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): NewsApiData

    companion object {
        private const val API_KEY = "c90b75b857d64154ba4436ff73f9074b"
        private const val MAIN_SEARCHING_WORD = "belarus"
        private const val SORT_BY = "publishedAt"
        const val GET_REQUEST_PARAMETERS =
            "language=${AppConstants.NEWS_API_LANGUAGE}&q=$MAIN_SEARCHING_WORD&sortBy=$SORT_BY&apiKey=$API_KEY"
    }
}