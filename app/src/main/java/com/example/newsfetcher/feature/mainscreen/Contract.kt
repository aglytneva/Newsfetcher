package com.example.newsfetcher.feature.mainscreen


import androidx.lifecycle.Lifecycle
import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.domain.ArticleModel

data class ViewState (
    val articles : List <ArticleModel>
)
//называем события как будто ползователь нажал на кнопку, показывает не то,
// что хотел пользователь, а именно что сделал
//Это событие

sealed class UiEvent : Event {
    data class onArticleClicked ( val index: Int ) : UiEvent()

}

sealed class DataEvent : Event {

    object loadArticles :DataEvent()
    data class onLoadArticlesSoursed ( val articles: List<ArticleModel>) : DataEvent()


}