package com.izhenius.newsapiapp.data.network.api

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsProvider {

    private var newsApi: NewsApi? = null

    fun provideApi(retrofit: Retrofit): NewsApi {
        if (newsApi == null) {
            newsApi = retrofit.create(NewsApi::class.java)
        }
        return newsApi!!
    }

    fun provideRetrofit(
        baseUrl: String,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    fun provideConverterFactory(): Converter.Factory {
        return MoshiConverterFactory.create()
    }
}