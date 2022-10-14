package com.example.domain.repository

import com.example.domain.news.entitie.News
import com.example.domain.topnews.entitie.TopNews

interface NewsRepository {

    suspend fun fetchNews(
        query: String?,
        from: String?,
        to: String?,
        sortBy: String,
        language: String
    ): List<News>

    suspend fun fetchTopNews(query: String, country: String, category: String): List<TopNews>

}