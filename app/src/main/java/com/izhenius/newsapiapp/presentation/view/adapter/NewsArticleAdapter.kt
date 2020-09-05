package com.izhenius.newsapiapp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.izhenius.newsapiapp.R
import com.izhenius.newsapiapp.data.entity.NewsArticle

class NewsArticleAdapter : RecyclerView.Adapter<NewsArticleViewHolder>() {

    private val items = mutableListOf<NewsArticle>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return NewsArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsArticleViewHolder, position: Int) {
        val newsArticle = items[position]
        val titleNewsArticle = newsArticle.title ?: ""
        val publishedAtNewsArticle = newsArticle.publishedAt ?: ""
        val urlToImageNewsArticle = newsArticle.urlToImage ?: ""
        holder.bind(titleNewsArticle, publishedAtNewsArticle, urlToImageNewsArticle)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(newItems: List<NewsArticle>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

}

class NewsArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageNewsArticle = view.findViewById<ImageView>(R.id.imageNewsArticle)
    private val titleNewsArticle = view.findViewById<TextView>(R.id.textViewTitleNewsArticle)
    private val publishedAtNewsArticle =
        view.findViewById<TextView>(R.id.textViewPublishedAtNewsArticle)

    fun bind(title: String, publishedAt: String, urlToImage: String) {
        titleNewsArticle.text = title
        publishedAtNewsArticle.text = publishedAt
        imageNewsArticle.load(urlToImage)
    }
}