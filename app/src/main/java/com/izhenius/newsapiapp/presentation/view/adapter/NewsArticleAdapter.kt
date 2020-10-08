package com.izhenius.newsapiapp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.izhenius.newsapiapp.R
import com.izhenius.newsapiapp.domain.model.NewsArticle
import com.izhenius.newsapiapp.util.AppConstants
import com.izhenius.newsapiapp.util.toString

class NewsArticleAdapter : RecyclerView.Adapter<NewsArticleViewHolder>() {

    private val items = mutableListOf<NewsArticle>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return NewsArticleViewHolder(view)
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

class NewsArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageNewsArticle = view.findViewById<ImageView>(R.id.imageNewsArticle)
    private val newsArticleTitle = view.findViewById<TextView>(R.id.textViewNewsArticleTitle)
    private val newsArticlePublishedAt =
        view.findViewById<TextView>(R.id.textViewNewsArticlePublishedAt)

    fun bind(title: String, publishedAt: String, urlToImage: String) {
        newsArticleTitle.text = title
        newsArticlePublishedAt.text = publishedAt
        imageNewsArticle.load(urlToImage)
    }
}