package com.example.mynews.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.news.entitie.News
import com.example.domain.news.usecase.GetNewsUseCase
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsPagingSource @Inject constructor(private val newsRepository: NewsRepository) :
    PagingSource<Int, News>() {

    val getNewsUseCase = GetNewsUseCase(newsRepository)

    override fun getRefreshKey(state: PagingState<Int, News>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = getNewsUseCase("bitcoin")
            LoadResult.Page(
                data = response,
                prevKey = null,//if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = null//nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(Throwable(e.message))
        }
    }
}