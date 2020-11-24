package com.izhenius.newsapiapp.presentation.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.izhenius.newsapiapp.databinding.ActivityMainBinding
import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.presentation.view.adapter.NewsArticleAdapter
import com.izhenius.newsapiapp.presentation.viewModel.NewsArticleViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val newsArticleAdapter = NewsArticleAdapter()
    private val newsArticleViewModel by viewModels<NewsArticleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.apply {
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
