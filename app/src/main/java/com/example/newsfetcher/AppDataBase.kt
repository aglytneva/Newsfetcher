package com.example.newsfetcher

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksDao
import com.example.newsfetcher.feature.bookmarks.data.local.model.BookmarksEntity

@Database (entities =[ BookmarksEntity::class], version = 2)
abstract class AppDataBase:RoomDatabase() {

    abstract fun bookMarksDao (): BookmarksDao

}