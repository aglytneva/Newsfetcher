package com.example.newsfetcher.feature.bookmarks.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfatcher.base.BaseViewModel
import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.bookmarks.domain.BookmarksInteractor
import kotlinx.coroutines.launch

class BookmarksScreenViewModel (private val interactor:BookmarksInteractor) : BaseViewModel <ViewState>(){

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }
    override fun initialViewState(): ViewState = ViewState(bookmarksArticles = emptyList(), errorText = "")
    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when(event) {
            is DataEvent.LoadBookmarks -> {
                viewModelScope.launch {
                    interactor.read().fold(
                        onError = {
                                  processDataEvent(DataEvent.OnFailedBookmarksLoaded(it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent
                                .OnSuccessBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }
           is DataEvent.OnSuccessBookmarksLoaded -> {
               Log.d("Room", "articleBookmark = ${event.bookmarksArticle}")

               return previousState.copy(bookmarksArticles = event.bookmarksArticle)

           }

            is DataEvent.OnFailedBookmarksLoaded -> {
                Log.d("Room", "articleBookmark не загружены")
                   return previousState
            }

            //при нажатии на кнопку удаляется статья в базе данных
            is UiEvent.OnArticleClicked -> {
                viewModelScope.launch {
                    interactor.delete(previousState.bookmarksArticles[event.index])
                }
                previousState.bookmarksArticles[event.index].favoriteArticlesChoice = true
                processDataEvent(DataEvent.LoadBookmarks)
                return null
            }
            else ->return null
        }

    }

}

