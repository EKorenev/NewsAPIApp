package com.izhenius.newsapiapp.data.database.news

import androidx.room.Database
import androidx.room.RoomDatabase
import com.izhenius.newsapiapp.data.database.news.dao.NewsArticleDao
import com.izhenius.newsapiapp.data.database.news.model.DatabaseNewsArticle

@Database(entities = [DatabaseNewsArticle::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsArticleDao(): NewsArticleDao
}
