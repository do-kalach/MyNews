package com.example.domain.topnews.usecase

import com.example.domain.data.Category
import com.example.domain.data.Country
import com.example.domain.repository.NewsRepository
import com.example.domain.topnews.entitie.TopNews

class GetTopNewsUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(
        query: String,
        country: Country,
        category: Category
    ): List<TopNews> {

        val categoryName = category.getCategory()

        val countryName = country.getLanguage()

        return newsRepository.fetchTopNews(query, countryName, categoryName)
    }
}