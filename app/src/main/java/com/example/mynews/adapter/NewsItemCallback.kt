package com.example.mynews.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.news.entitie.News

class NewsItemCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean =
        oldItem.url == newItem.url


    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean =
        oldItem == newItem
}