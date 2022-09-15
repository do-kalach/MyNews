package com.example.domain.data

enum class SortBy {
    RELEVANCY,
    POPULARITY,
    PUBLISHEDAT;

    companion object {
        fun getSort(sortBy: SortBy): String {
            return when (sortBy) {
                RELEVANCY -> "relevancy"
                POPULARITY -> "popularity"
                PUBLISHEDAT -> "publishedAt"
            }
        }
    }
}