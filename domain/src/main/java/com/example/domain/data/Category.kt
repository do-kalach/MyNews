package com.example.domain.data

enum class Category {
    BUISINESS,
    ENTERTAINMENT,
    GENERAL,
    HEALTH,
    SCIENCE,
    SPORTS,
    TECHNOLOGY;

    companion object {
        fun getCategory(category: Category): String {
            return when (category) {
                BUISINESS -> "business"
                ENTERTAINMENT -> "entertainment"
                GENERAL -> "general"
                HEALTH -> "health"
                SCIENCE -> "science"
                SPORTS -> "sports"
                TECHNOLOGY -> "technology"
            }
        }
    }
}