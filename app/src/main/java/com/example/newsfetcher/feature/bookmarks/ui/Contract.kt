package com.example.newsfetcher.feature.bookmarks.ui

import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.domain.ArticleModel

data class ViewState (
    val bookmarksArticles : List <ArticleModel>
)
sealed class UiEvent ()
sealed class DataEvent : Event {

    object LoadBookmarks :DataEvent()
    data class OnSuccessBookmarksLoaded ( val bookmarksArticle: List<ArticleModel>) : DataEvent()
    data class OnFailedBookmarksLoaded ( val throwable: Throwable) : DataEvent()

}

