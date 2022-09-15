package com.example.data.mapper

import com.example.data.model.EverythingNews
import com.example.domain.news.entitie.News

class EverythingMapper : EntityMapper<EverythingNews, List<News>> {

    override fun mapFromEntity(news: EverythingNews): List<News> {
        return news.articles.map { everythingNews ->
            News(
                author = everythingNews.author,
                content = everythingNews.content,
                description = everythingNews.description,
                publishedAt = everythingNews.publishedAt,
                source = everythingNews.source.name,
                title = everythingNews.title,
                url = everythingNews.url,
                urlToImage = everythingNews.urlToImage
            )
        }
    }
}
