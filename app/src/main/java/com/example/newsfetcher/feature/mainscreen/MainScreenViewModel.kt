package com.example.newsfetcher.feature.mainscreen

import android.util.Log
import android.widget.Toast
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


    override fun initialViewState() = ViewState(
        articleList = emptyList(),
        articlesShown = emptyList(),
        editText = "",
        isSearchEnabled = false,
        isLoading = false,
        errorText=""
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.loadArticles -> {
                viewModelScope.launch {
                    interactor.getArticles().fold(
                        onError = {
                            processDataEvent(DataEvent.OnFailedArticleLoaded(it))
//                            Log.e("Error", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.onLoadArticlesSoursed(it))

                        }
                    )

                }
                return previousState.copy(isLoading = true)
            }
            is DataEvent.onLoadArticlesSoursed -> {
                return previousState.copy(
                    articleList = event.articles, articlesShown = event.articles, isLoading = false
                )
            }
            is DataEvent.OnFailedArticleLoaded -> {
                return previousState.copy(errorText = "Упс. что-то сломалось")
            }


            //при нажатии на кнопку создается новая статья в базе данных
            is UiEvent.OnArticleClicked -> {
                previousState.articleList[event.index].favoriteArticlecChoice = true
                viewModelScope.launch {

                    bookmarksInteractor.create(previousState.articlesShown[event.index])

                }
                return null
            }

            //при нажатии на кнопку поиск
            is UiEvent.OnSearchButtonClicked -> {
                return previousState.copy(
                    articlesShown = if (
                        previousState.isSearchEnabled
//                        && previousState.editText == ""
                    ) previousState.articleList
                    else previousState.articlesShown,
                    isSearchEnabled = !previousState.isSearchEnabled
                )
            }

            //ui событие набора текста, получает текст, копирует новое состояние
            // экрана предварительно отфильтровав список статей, полученных из сети
            is UiEvent.OnSearchEdit -> {
//                previousState.editText = event.text
                return previousState.copy(articlesShown = previousState.articleList.filter {
                    it.title.contains(event.text)
                }, isSearchEnabled = previousState.isSearchEnabled)
            }

            else -> return null
        }
        return null
    }

}


