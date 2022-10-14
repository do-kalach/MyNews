package com.example.domain.data

enum class SortBy(private val sortName: String) {
    RELEVANCY("relevancy"),
    POPULARITY("popularity"),
    PUBLISHEDAT("publishedAt");

    fun getSort(): String = this.sortName
}