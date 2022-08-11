package com.example.newsfetcher.feature.domain

import android.os.Parcel
import android.os.Parcelable

data class ArticleModel(

    val author: String?,
    var title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
    var favoriteArticlecChoice:Boolean=false
)
