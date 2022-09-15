package com.example.data.mapper

import com.example.data.model.HeadLinesNews
import com.example.domain.topnews.entitie.TopNews

class TopNewsMapper : EntityMapper<HeadLinesNews, List<TopNews>> {

    override fun mapFromEntity(news: HeadLinesNews): List<TopNews> {
        return news.articles.map { everythingNews ->
            TopNews(
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