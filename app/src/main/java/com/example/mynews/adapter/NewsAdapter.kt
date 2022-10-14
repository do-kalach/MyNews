package com.example.mynews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.domain.news.entitie.News
import com.example.mynews.R
import com.example.mynews.databinding.ItemNewsBinding

class NewsAdapter(val setOnClickListener:SetOnClickListener) : ListAdapter<News, NewsAdapter.NewsViewHolder>(NewsItemCallback()) {

    private lateinit var binding: ItemNewsBinding
    private var translateAnim:Animation? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        translateAnim = AnimationUtils.loadAnimation(parent.context, R.anim.translate_anim)
        translateAnim?.let {
         it.interpolator = LinearOutSlowInInterpolator()
        }
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.newsImage.load(news.urlToImage){
                error(R.drawable.ic_not_image_24)
            }
            binding.newsTitle.text = news.title
            binding.newsSourceName.text = news.source
            binding.newsPublishDate.text = news.publishedAt
            binding.root.setOnClickListener{
                it.startAnimation(translateAnim)
                setOnClickListener.onClickListener(news)
            }
        }
    }

    interface SetOnClickListener{
        fun onClickListener(news:News)
    }

}