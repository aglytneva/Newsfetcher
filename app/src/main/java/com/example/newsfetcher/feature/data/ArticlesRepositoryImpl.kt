package com.example.newsfetcher.feature.data

import com.example.newsfetcher.feature.data.ArticlesRepository
import com.example.newsfetcher.feature.domain.ArticleModel

class ArticlesRepositoryImpl (private val source: ArticlesRemoteSourse) : ArticlesRepository {

    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articleList.map {
            it.toDomain()
        }
    }
}