package com.izhenius.newsapiapp.data.database.news.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.izhenius.newsapiapp.data.database.news.model.DatabaseNewsArticle

@Dao
interface NewsArticleDao {
    @Query("SELECT * FROM news")
    fun getAll(): List<DatabaseNewsArticle>

    @Query("SELECT * FROM news WHERE id = :id")
    fun getById(id: String): DatabaseNewsArticle?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(databaseNewsArticles: List<DatabaseNewsArticle>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsArticle(databaseNewsArticle: DatabaseNewsArticle)

    @Query("DELETE FROM news")
    fun deleteAll()

    @Delete
    fun deleteNewsArticle(databaseNewsArticle: DatabaseNewsArticle)
}
