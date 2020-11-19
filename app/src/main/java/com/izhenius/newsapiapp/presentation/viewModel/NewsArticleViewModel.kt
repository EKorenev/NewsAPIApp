package com.izhenius.newsapiapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izhenius.newsapiapp.di.GetNewsArticlesUseCaseProvider
import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.domain.model.Result
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
            val result = getNewsArticlesUseCase(page)
            if (result is Result.Success) {
                _articles.value = result.value
            }
        }
    }
}
