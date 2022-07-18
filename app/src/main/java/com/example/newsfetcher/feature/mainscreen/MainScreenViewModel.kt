package com.example.newsfetcher.feature.mainscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfatcher.base.BaseViewModel
import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.domain.ArticlesInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel (private val interactor : ArticlesInteractor): BaseViewModel <ViewState> () {

    init {
        processDataEvent(DataEvent.loadArticles)
    }

    override fun initialViewState()= ViewState (articles = emptyList())

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
            return previousState.copy(articles = event.articles)
        }
        else -> return null
       }
    }
}