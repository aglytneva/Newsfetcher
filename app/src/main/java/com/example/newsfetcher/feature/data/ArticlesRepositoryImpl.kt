package com.example.newsfetcher.feature.data

import com.example.newsfetcher.feature.data.ArticlesRepository
import com.example.newsfetcher.feature.domain.ArticleModel
// реализация интерфейса репозитория, хранящий полученные статьи из сети
class ArticlesRepositoryImpl (private val source: ArticlesRemoteSourse) : ArticlesRepository {

    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articleList.asSequence()
            .map {it.toDomain()}
            .sortedBy { it.publishedAt}
            .toList()

    }
}