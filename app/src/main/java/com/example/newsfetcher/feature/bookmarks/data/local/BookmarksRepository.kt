package com.example.newsfetcher.feature.bookmarks.data.local

import com.example.newsfetcher.feature.bookmarks.data.local.model.BookmarksEntity
import com.example.newsfetcher.feature.domain.ArticleModel

interface BookmarksRepository {

    suspend fun create(model: ArticleModel)

    suspend fun read(): List<ArticleModel>

    suspend fun update(model: ArticleModel)

    suspend fun delete(model: ArticleModel)

}