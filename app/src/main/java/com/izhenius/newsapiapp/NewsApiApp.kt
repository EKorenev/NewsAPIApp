package com.izhenius.newsapiapp

import android.app.Application
import com.izhenius.newsapiapp.data.database.news.NewsDatabase
import com.izhenius.newsapiapp.di.NewsDatabaseProvider

class NewsApiApp : Application() {

    companion object {
        lateinit var newsDatabase: NewsDatabase
    }

    override fun onCreate() {
        super.onCreate()
        newsDatabase = NewsDatabaseProvider.provideDatabase(this)
    }
}
