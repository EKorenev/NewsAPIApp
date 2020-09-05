package com.izhenius.newsapiapp.presentation.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.izhenius.newsapiapp.R
import com.izhenius.newsapiapp.data.entity.NewsArticle
import com.izhenius.newsapiapp.presentation.view.adapter.NewsArticleAdapter
import com.izhenius.newsapiapp.presentation.viewModel.NewsArticleViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val newsArticleAdapter = NewsArticleAdapter()
    private val newsArticleViewModel by viewModels<NewsArticleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            adapter = newsArticleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        val newsArticlesObserver = Observer<List<NewsArticle>> {
            it ?: return@Observer
            newsArticleAdapter.addItems(it)
        }

        newsArticleViewModel.articles.observe(this, newsArticlesObserver)
    }
}