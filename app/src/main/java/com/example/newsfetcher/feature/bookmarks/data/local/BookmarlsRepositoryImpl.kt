package com.example.newsfetcher.feature.bookmarks.data.local

import com.example.newsfetcher.feature.bookmarks.data.toDomain
import com.example.newsfetcher.feature.bookmarks.data.toEntity
import com.example.newsfetcher.feature.domain.ArticleModel

class BookmarksRepositoryImpl (private val bookmaksLocalSourse: BookmaksLocalSourse) : BookmarksRepository {
    override suspend fun create(model: ArticleModel) {
        bookmaksLocalSourse.create(model.toEntity())
    }

    override suspend fun read(): List<ArticleModel> {
        return bookmaksLocalSourse.read().map { it.toDomain() }
    }

    override suspend fun update(model: ArticleModel) {
        bookmaksLocalSourse.update(model.toEntity())
    }

    override suspend fun delete(model: ArticleModel) {
        bookmaksLocalSourse.delete(model.toEntity())
    }

}