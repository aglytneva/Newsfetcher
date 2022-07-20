package com.example.newsfetcher.feature.bookmarks.ui

import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.domain.ArticleModel

data class ViewState (
    val bookmarksArticles : List <ArticleModel>
)

sealed class DataEvent : Event {

    object loadArticles :DataEvent()
    data class onLoadArticlesSoursed ( val articles: List<ArticleModel>) : DataEvent()


}

sealed class UiEvent ()