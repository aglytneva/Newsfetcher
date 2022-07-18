package com.example.newsfetcher.feature.mainscreen


import androidx.lifecycle.Lifecycle
import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.domain.ArticleModel

data class ViewState (
    val articles : List <ArticleModel>
)

sealed class DataEvent : Event {

    object loadArticles :DataEvent()
    data class onLoadArticlesSoursed ( val articles: List<ArticleModel>) : DataEvent()


}