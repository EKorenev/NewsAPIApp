package com.izhenius.newsapiapp.di

import com.izhenius.newsapiapp.domain.usecase.GetNewsArticlesUseCaseImpl

object GetNewsArticlesUseCaseProvider {
    fun provideUseCase() = GetNewsArticlesUseCaseImpl(NewsRepositoryProvider.provideRepository())
}
