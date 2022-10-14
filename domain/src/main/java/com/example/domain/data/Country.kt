package com.example.domain.data

enum class Country(private val language: String) {
    RU("ru"),
    DE("de"),
    UA("ua");

    fun getLanguage(): String = this.language
}