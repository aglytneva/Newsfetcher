package com.example.newsfetcher.feature.bookmarks.domain

import com.example.newsfatcher.base.Either
import com.example.newsfatcher.base.attempt
import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksRepository
import com.example.newsfetcher.feature.domain.ArticleModel

class BookmarksInteractor (private val bookmarksRepository: BookmarksRepository) {

    suspend  fun create(model: ArticleModel) {
        attempt {bookmarksRepository.create(model)}
    }

    suspend fun read(): Either<Throwable, List<ArticleModel>> {
        return attempt { bookmarksRepository.read() }
    }

    suspend fun update(model: ArticleModel) {
        attempt {bookmarksRepository.update(model)}
    }

    suspend fun delete(model: ArticleModel) {
        attempt {bookmarksRepository.delete(model)}
    }
}