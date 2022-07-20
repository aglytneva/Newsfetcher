package com.example.newsfetcher.feature.bookmarks.data.local

import androidx.room.*
import com.example.newsfetcher.feature.bookmarks.data.local.model.BookmarksEntity
import com.example.newsfetcher.feature.bookmarks.di.BOOKMARKS_TABLE

@Dao
interface BookmarksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create (entity: BookmarksEntity)
    @Query ("SELECT*FROM $BOOKMARKS_TABLE")
    suspend fun read(): List<BookmarksEntity>

    @Update
    suspend fun update (entity: BookmarksEntity)

    @Delete
    suspend fun delete (entity: BookmarksEntity)
}