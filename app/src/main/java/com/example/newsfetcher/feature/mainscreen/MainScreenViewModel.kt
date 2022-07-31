package com.example.newsfetcher.feature.mainscreen

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfatcher.base.BaseViewModel
import com.example.newsfatcher.base.Event
import com.example.newsfetcher.feature.bookmarks.domain.BookmarksInteractor
import com.example.newsfetcher.feature.domain.ArticleModel
import com.example.newsfetcher.feature.domain.ArticlesInteractor
import kotlinx.coroutines.internal.artificialFrame
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
    override fun initialViewState() = ViewState(
        articleList = emptyList(),
        articlesShown = emptyList(),
        editText = "",
        isSearchEnabled = false,
//        articleInfo = ArticleModel(
//            author = "",
//            description = "",
//            url = "",
//            title = "",
//            urlToImage = "",
//            publishedAt = "",
//            content = "",
//            bookmarkAddedFlag = false
//            )
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.loadArticles -> {
                viewModelScope.launch {
                    interactor.getArticles().fold(
                        onError = {
                            Log.e("Error", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.onLoadArticlesSoursed(it))

                        }
                    )
                }
                return null
            }
            is DataEvent.onLoadArticlesSoursed -> {
                return previousState.copy(
                    articleList = event.articles, articlesShown = event.articles,
                )
            }


            //при нажатии на кнопку создается новая статья в базе данных
            is UiEvent.OnArticleClicked -> {
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
                        && previousState.editText == ""
                    ) previousState.articleList
                    else previousState.articlesShown,
                    isSearchEnabled = !previousState.isSearchEnabled
                )
            }

            //ui событие набора текста, получает текст, копирует новое состояние
            // экрана предварительно отфильтровав список статей, полученных из сети
            is UiEvent.OnSearchEdit -> {
                previousState.editText = event.text
                return previousState.copy(articlesShown = previousState.articleList.filter {
                    it.title.contains(event.text)
                })
            }

            else -> return null
        }
        return null
    }

}


