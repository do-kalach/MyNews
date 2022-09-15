package com.example.mynews.ui

import androidx.lifecycle.ViewModel
import com.example.domain.data.Category
import com.example.domain.data.Country
import com.example.domain.news.entitie.News
import com.example.domain.news.usecase.GetNewsUseCase
import com.example.domain.repository.NewsRepository
import com.example.domain.topnews.entitie.TopNews
import com.example.domain.topnews.usecase.GetTopNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    private val getNewsUseCase = GetNewsUseCase(newsRepository)
    private val getTopNewsUseCase = GetTopNewsUseCase(newsRepository)

    suspend fun fetchNews(): Flow<News> =
        getNewsUseCase("bitcoin").asFlow()

    suspend fun fetchTopNews(): Flow<TopNews> =
        getTopNewsUseCase("bitcoin", Country.RU, Category.SPORTS).asFlow()

}