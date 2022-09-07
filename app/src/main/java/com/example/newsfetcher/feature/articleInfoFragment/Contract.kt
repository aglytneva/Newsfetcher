package com.example.newsfetcher.feature.articleInfoFragment

import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.domain.ArticleModel

data class ViewState(
    val articleTitle: String?,
    val articleDescription: String?,
    val articleContent: String?,
    val articleUrlToImage: String?,
    val articleLink: String?
)

sealed class UiEvent() : Event {

}

sealed class DataEvent() : Event {
    data class ShowArticle(
        val title:String,
        val description:String,
        val url:String,
        val urlToImage:String) : DataEvent()
}