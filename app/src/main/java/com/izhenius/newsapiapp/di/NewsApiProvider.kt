package com.izhenius.newsapiapp.di

import com.izhenius.newsapiapp.data.network.api.news.NewsApiService
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsApiProvider {

    @Volatile
    private var api: NewsApiService? = null

    fun provideApi(retrofit: Retrofit): NewsApiService {
        return api ?: synchronized(this) {
            api ?: retrofit.create(NewsApiService::class.java).also {
                api = it
            }
        }
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