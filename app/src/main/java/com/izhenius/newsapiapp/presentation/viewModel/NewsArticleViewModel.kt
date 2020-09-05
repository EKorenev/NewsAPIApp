package com.izhenius.newsapiapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izhenius.newsapiapp.data.entity.NewsArticle
import com.izhenius.newsapiapp.data.repository.provideNewsRepository
import kotlinx.coroutines.launch

class NewsArticleViewModel : ViewModel() {

    private val mutableArticles = MutableLiveData<List<NewsArticle>>()
    val articles: LiveData<List<NewsArticle>> get() = mutableArticles

    init {
        downloadStartListOfNews()
    }

    fun downloadStartListOfNews() {
        downloadListOfNews(20, 1)
    }

    fun downloadListOfNews(pageSize: Int, page: Int) {
        viewModelScope.launch {
            mutableArticles.value = provideNewsRepository().getListOfNews(pageSize, page)
        }
    }
}