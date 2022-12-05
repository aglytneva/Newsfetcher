package com.example.newsfetcher.feature.data.model

import com.google.gson.annotations.SerializedName
// создание листа, аккумулирующего все полученные статьи
data class ArticlesRemoteModel (
    @SerializedName("articles")
    val articleList : List<ArticleRemoteModel>
)