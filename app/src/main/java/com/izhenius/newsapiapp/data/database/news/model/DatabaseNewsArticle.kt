package com.izhenius.newsapiapp.data.database.news.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class DatabaseNewsArticle(
    @PrimaryKey @NonNull val id: String,
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val publishedAt: String?
)