package com.izhenius.newsapiapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izhenius.newsapiapp.di.GetNewsArticlesUseCaseProvider
import com.izhenius.newsapiapp.domain.model.NewsArticle
import kotlinx.coroutines.launch

class NewsArticleViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<NewsArticle>>()
    val articles: LiveData<List<NewsArticle>> get() = _articles

    private val getNewsArticlesUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetNewsArticlesUseCaseProvider.provideUseCase()
    }

    init {
        downloadStartListOfNews()
    }

    fun downloadStartListOfNews() {
        downloadListOfNews(1)
    }

    fun downloadListOfNews(page: Int) {
        viewModelScope.launch {
            _articles.value = getNewsArticlesUseCase(page)
        }
    }
}
