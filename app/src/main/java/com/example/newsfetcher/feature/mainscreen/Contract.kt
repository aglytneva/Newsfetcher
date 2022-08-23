package com.example.newsfetcher.feature.mainscreen


import androidx.lifecycle.Lifecycle
import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.domain.ArticleModel

data class ViewState (
    val isLoading: Boolean,
    val isSearchEnabled: Boolean,
    var editText: String,
    val articlesShown: List<ArticleModel>,
    val articleList: List<ArticleModel>,
//    val articleInfo : ArticleModel
)
//называем события как будто ползователь нажал на кнопку, показывает не то,
// что хотел пользователь, а именно что сделал
//Это событие

sealed class UiEvent : Event {
    data class OnArticleClicked(val index: Int) : UiEvent()
    data class OnArticleClickedForInfo(val index: Int) : UiEvent()
    object OnSearchButtonClicked : UiEvent()

    // описываем event когда вводится текст
    data class OnSearchEdit (val text :String) :UiEvent()
}

sealed class DataEvent : Event {

    object loadArticles :DataEvent()
    data class onLoadArticlesSoursed ( val articles: List<ArticleModel>) : DataEvent()



}