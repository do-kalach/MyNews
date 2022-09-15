package com.example.data.mapper

interface EntityMapper<T, O> {

    fun mapFromEntity(news: T): O

}