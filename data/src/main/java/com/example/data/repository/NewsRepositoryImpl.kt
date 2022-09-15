package com.example.data.repository

import com.example.data.mapper.EverythingMapper
import com.example.data.mapper.TopNewsMapper
import com.example.data.network.NewsApi
import com.example.domain.news.entitie.News
import com.example.domain.repository.NewsRepository
import com.example.domain.topnews.entitie.TopNews

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {

    override suspend fun fetchNews(
        query: String,
        from: String?,
        to: String?,
        sortBy: String,
        language: String
    ): List<News> {
        val mapper = EverythingMapper()

        val news = newsApi.fetchNews(query, sortBy = sortBy)

        return mapper.mapFromEntity(news)
    }

    override suspend fun fetchTopNews(
        query: String,
        country: String,
        category: String
    ): List<TopNews> {

        val mapper = TopNewsMapper()

        val headLinesNews = newsApi.fetchTopHeadLinesNews(query, country, category)

        return mapper.mapFromEntity(headLinesNews)
    }

}