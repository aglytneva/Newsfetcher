package com.example.newsfetcher.feature.bookmarks.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfatcher.base.BaseViewModel
import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.bookmarks.domain.BookmarksInteractor
import com.example.newsfetcher.feature.mainscreen.DataEvent
import kotlinx.coroutines.launch

class BookmarksScreenViewModel (private val interactor:BookmarksInteractor) : BaseViewModel <ViewState>(){

    override fun initialViewState(): ViewState = ViewState(bookmarksArticles = emptyList())
    override fun reduce(event: Event, previousSTATE: ViewState): ViewState? {
        return null
    }

}

