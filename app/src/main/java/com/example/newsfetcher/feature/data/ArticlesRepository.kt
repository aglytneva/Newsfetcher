package com.example.newsfetcher.feature.data

import com.example.newsfetcher.feature.data.model.ArticlesRemoteModel
import com.example.newsfetcher.feature.domain.ArticleModel
// интерфейс репозитория
interface ArticlesRepository {

    suspend fun getArticles ():List<ArticleModel>
}