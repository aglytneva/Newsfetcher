package com.example.newsfetcher.feature.mainscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfatcher.base.BaseViewModel
import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.bookmarks.domain.BookmarksInteractor
import com.example.newsfetcher.feature.domain.ArticlesInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel (private val interactor : ArticlesInteractor,
                           private val bookmarksInteractor: BookmarksInteractor)
    : BaseViewModel <ViewState> () {

    init {
        processDataEvent(DataEvent.loadArticles)
    }
//    val isSearchEnabled:Boolean,
//    val articlesShown:List<ArticleModel>,
//
//
//    val articles : List <ArticleModel>
    override fun initialViewState()= ViewState (
        articleList = emptyList(),
        articlesShown = emptyList(),
        isSearchEnabled =false )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
        is DataEvent.loadArticles -> {
               viewModelScope.launch {
                   interactor.getArticles().fold(
                       onError ={
                            Log.e("Error", it.localizedMessage)
                       },
                       onSuccess = {
                           processDataEvent( DataEvent.onLoadArticlesSoursed(it))

                       }
                   )
               }
            return null
        }
        is DataEvent.onLoadArticlesSoursed -> {
            return previousState.copy(articleList = event.articles,articlesShown = event.articles)
        }
        //при нажатии на кнопку создается новая статья в базе данных
        is UiEvent.OnArticleClicked -> {
            viewModelScope.launch {
                bookmarksInteractor.create(previousState.articlesShown[event.index])
            }
            return null
        }

        //при нажатии на кнопку создается новая статья в базе данных
        is UiEvent.OnSearchButtonClicked -> {
            return previousState.copy(isSearchEnabled = !previousState.isSearchEnabled)
        }
        else -> return null
       }
    }
}