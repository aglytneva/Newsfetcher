package com.example.newsfetcher.feature.bookmarks.ui

import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.domain.ArticleModel

data class ViewState (
    val bookmarksArticles : List <ArticleModel>,
    val errorText:String
)
sealed class UiEvent : Event {
    data class OnArticleClicked(val index: Int) : UiEvent()

}
sealed class DataEvent : Event {

    object LoadBookmarks :DataEvent()
    data class OnSuccessBookmarksLoaded ( val bookmarksArticle: List<ArticleModel>) : DataEvent()
    data class OnFailedBookmarksLoaded ( val throwable: Throwable) : DataEvent()

}

