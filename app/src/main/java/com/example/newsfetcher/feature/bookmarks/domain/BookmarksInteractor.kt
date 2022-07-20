package com.example.newsfetcher.feature.bookmarks.domain

import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksRepository
import com.example.newsfetcher.feature.domain.ArticleModel

class BookmarksInteractor (private val bookmarksRepository: BookmarksRepository) {

    suspend  fun create(model: ArticleModel) {
        bookmarksRepository.create(model)
    }

    suspend fun read(): List<ArticleModel> {
        return bookmarksRepository.read()
    }

    suspend fun update(model: ArticleModel) {
        bookmarksRepository.update(model)
    }

    suspend fun delete(model: ArticleModel) {
        bookmarksRepository.delete(model)
    }
}