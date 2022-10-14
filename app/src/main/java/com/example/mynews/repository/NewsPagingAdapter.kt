package com.example.mynews.repository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.domain.news.entitie.News
import com.example.mynews.adapter.NewsItemCallback
import com.example.mynews.databinding.ItemNewsBinding

class NewsPagingAdapter :
    PagingDataAdapter<News, NewsPagingAdapter.NewsViewHolder>(NewsItemCallback()) {

    private lateinit var binding: ItemNewsBinding

    class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(news:News){
            binding.newsImage.load(news.urlToImage)
            binding.newsTitle.text = news.title
            binding.newsSourceName.text = news.source
            binding.newsPublishDate.text = news.publishedAt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item!!)
    }
}