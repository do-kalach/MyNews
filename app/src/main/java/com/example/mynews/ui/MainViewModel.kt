package com.example.mynews.ui

import androidx.lifecycle.ViewModel
import com.example.domain.data.Category
import com.example.domain.data.Country
import com.example.domain.data.NetworkResult
import com.example.domain.news.entitie.News
import com.example.domain.news.usecase.GetNewsUseCase
import com.example.domain.repository.NewsRepository
import com.example.domain.topnews.entitie.TopNews
import com.example.domain.topnews.usecase.GetTopNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
) : ViewModel() {

    private val getNewsUseCase = GetNewsUseCase(newsRepository)
    private val getTopNewsUseCase = GetTopNewsUseCase(newsRepository)

    fun fetchNews(query: String?): Flow<NetworkResult<List<News>>> = flow {
        emit(NetworkResult.Loading)
        try {
            val news = getNewsUseCase(query)
            emit(NetworkResult.Success(news))
        } catch (e: ConnectException) {
            emit(NetworkResult.ResponseError(e.message))
        } catch (e: Exception) {
            emit(NetworkResult.UnknownError(e.message))
        }
    }

    suspend fun fetchTopNews(): List<TopNews> =
        getTopNewsUseCase("bitcoin", Country.RU, Category.SPORTS)

}