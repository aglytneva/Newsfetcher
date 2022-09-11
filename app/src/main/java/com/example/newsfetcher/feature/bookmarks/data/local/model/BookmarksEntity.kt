package com.example.newsfetcher.feature.bookmarks.data.local.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsfetcher.feature.bookmarks.di.BOOKMARKS_TABLE

@Entity (tableName = BOOKMARKS_TABLE)
data class BookmarksEntity (

    @PrimaryKey
    @ColumnInfo(name= "url")
    val url :String,

    @ColumnInfo(name= "author")
    val author :String,

    @ColumnInfo(name= "title")
    val title :String,

    @ColumnInfo(name= "description")
    val description :String,



    @ColumnInfo(name= "urlToImage")
    val urlToImage :String,

    @ColumnInfo(name= "publishedAt")
    val publishedAt :String,

    @ColumnInfo(name= "content")
    val content :String,
)