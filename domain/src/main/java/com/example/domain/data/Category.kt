package com.example.domain.data

enum class Category(private val nameCategory: String) {
    BUISINESS("business"),
    ENTERTAINMENT("entertainment"),
    GENERAL("general"),
    HEALTH("health"),
    SCIENCE("science"),
    SPORTS("sports"),
    TECHNOLOGY("technology");

    fun getCategory(): String = this.nameCategory
}
