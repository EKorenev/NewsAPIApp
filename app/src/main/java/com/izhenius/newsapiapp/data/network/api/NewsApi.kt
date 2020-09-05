package com.izhenius.newsapiapp.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "c90b75b857d64154ba4436ff73f9074b"

interface NewsApi {
    @GET("/v2/everything?language=en&q=belarus&sortBy=publishedAt&apiKey=$API_KEY")
    suspend fun getListOfNews(
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): NewsApiData
}