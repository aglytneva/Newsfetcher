package com.example.newsfetcher.feature.bookmarks.data

import com.example.newsfetcher.feature.bookmarks.data.local.model.BookmarksEntity
import com.example.newsfetcher.feature.domain.ArticleModel

fun BookmarksEntity.toDomain ()= ArticleModel (
    author = author,
    title = title,
    description = description ,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)

fun ArticleModel.toEntity ()= BookmarksEntity (

    author = author,
    title = title,
    description = description ,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)