package com.izhenius.newsapiapp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.izhenius.newsapiapp.databinding.LayoutItemBinding
import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.util.AppConstants
import com.izhenius.newsapiapp.util.toString

class NewsArticleAdapter : RecyclerView.Adapter<NewsArticleViewHolder>() {

    private val items = mutableListOf<NewsArticle>()
    private lateinit var binding: LayoutItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleViewHolder {
        binding = LayoutItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsArticleViewHolder, position: Int) {
        val newsArticle = items[position]
        val newsArticleTitle = newsArticle.title.orEmpty()
        val newsArticlePublishedAt =
            newsArticle.publishedAt?.toString(AppConstants.NEWS_ARTICLE_DATE_FORMAT).orEmpty()
        val newsArticleUrlToImage = newsArticle.urlToImage.orEmpty()
        holder.bind(newsArticleTitle, newsArticlePublishedAt, newsArticleUrlToImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(newItems: List<NewsArticle>) {
        if (newItems.isNotEmpty()) {
            items.addAll(newItems)
            val newItemsCount = newItems.size
            val newItemsPositionStart = items.lastIndex - newItemsCount
            notifyItemRangeInserted(newItemsPositionStart, newItemsCount)
        }
    }
}

class NewsArticleViewHolder(layoutItemBinding: LayoutItemBinding) :
    RecyclerView.ViewHolder(layoutItemBinding.root) {

    private val imageNewsArticle = layoutItemBinding.imageNewsArticle
    private val newsArticleTitle = layoutItemBinding.textViewNewsArticleTitle
    private val newsArticlePublishedAt = layoutItemBinding.textViewNewsArticlePublishedAt

    fun bind(title: String, publishedAt: String, urlToImage: String) {
        newsArticleTitle.text = title
        newsArticlePublishedAt.text = publishedAt
        imageNewsArticle.load(urlToImage)
    }
}
