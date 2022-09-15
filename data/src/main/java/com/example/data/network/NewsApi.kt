package com.example.data.network

import com.example.data.model.EverythingNews
import com.example.data.model.HeadLinesNews
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun fetchNews(
        @Query("q") query: String,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("language") language: String = "ru"
    ): EverythingNews

    @GET("top-headlines")
    suspend fun fetchTopHeadLinesNews(
        @Query("q") query: String,
        @Query("country") country: String = "ru",
        @Query("category") category: String? = null
    ): HeadLinesNews

}