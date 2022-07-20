package com.example.newsfetcher.feature.bookmarks.data.local

import androidx.room.*
import com.example.newsfetcher.feature.bookmarks.data.local.model.BookmarksEntity
import com.example.newsfetcher.feature.bookmarks.di.BOOKMARKS_TABLE

class BookmaksLocalSourse (private  val bookmarksDao: BookmarksDao) {

    suspend fun create (entity: BookmarksEntity) {
        bookmarksDao.create(entity)
    }

    suspend fun read(): List<BookmarksEntity> {
        return  bookmarksDao.read()
    }


    suspend fun update (entity: BookmarksEntity) {
        bookmarksDao.update(entity)
    }

    suspend fun delete (entity: BookmarksEntity) {
        bookmarksDao.delete(entity)
    }

}