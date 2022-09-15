package com.example.domain.news.usecase

import com.example.domain.data.SortBy
import com.example.domain.news.entitie.News
import com.example.domain.repository.NewsRepository

class GetNewsUseCase(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(
        query: String,
        from: String? = null,
        to: String? = null,
        sortBy: SortBy = SortBy.PUBLISHEDAT,
        language: String = "ru"
    ): List<News> {

        val sortedBy = SortBy.getSort(sortBy)

        return newsRepository.fetchNews(query, from, to, sortedBy, language)
    }
}