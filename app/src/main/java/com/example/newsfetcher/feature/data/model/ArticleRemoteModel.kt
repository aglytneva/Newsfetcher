package com.example.newsfetcher.feature.data.model

import com.google.gson.annotations.SerializedName
// удаленная модель статей, получаемых с сети, приводим наименования к нашим значениям
data class ArticleRemoteModel (
    @SerializedName( "author")
    val author :String?,

    @SerializedName("title")
    val title :String?,

    @SerializedName("description")
    val description :String?,

    @SerializedName("url")
    val url :String?,

    @SerializedName("urlToImage")
    val urlToImage :String?,

    @SerializedName("publishedAt")
    val publishedAt :String?,

    @SerializedName("content")
    val content :String?,



)