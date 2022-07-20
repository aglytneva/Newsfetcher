package com.example.newsfetcher.feature.bookmarks.data.local

import com.example.newsfetcher.feature.bookmarks.data.local.model.BookmarksEntity
import com.example.newsfetcher.feature.domain.ArticleModel

interface BookmarksRepository {

    suspend fun create(entity: ArticleModel)

    suspend fun read(): List<ArticleModel>

    suspend fun update(entity: ArticleModel)

    suspend fun delete(entity: ArticleModel)

}