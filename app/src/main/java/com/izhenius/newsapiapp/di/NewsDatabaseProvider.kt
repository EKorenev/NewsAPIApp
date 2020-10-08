package com.izhenius.newsapiapp.di

import android.app.Application
import androidx.room.Room
import com.izhenius.newsapiapp.data.database.news.NewsDatabase

object NewsDatabaseProvider {

    @Volatile
    private var database: NewsDatabase? = null

    fun provideDatabase(app: Application): NewsDatabase {
        return database ?: synchronized(this) {
            database ?: buildDatabase(app).also {
                database = it
            }
        }
    }

    private fun buildDatabase(app: Application): NewsDatabase {
        return Room
            .databaseBuilder(app, NewsDatabase::class.java, "news")
            .fallbackToDestructiveMigration()
            .build()
    }
}