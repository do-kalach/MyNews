package com.example.domain.data

enum class Country {
    RU,
    US,
    UA;

    companion object {
        fun getCountry(country: Country): String {
            return when (country) {
                RU -> "ru"
                US -> "us"
                UA -> "ua"
            }
        }
    }
}