package com.example.newsfetcher.feature.articleInfoFragment


import com.example.newsfatcher.base.BaseViewModel
import com.example.newsfatcher.base.Event


class ArticleInfoViewModel: BaseViewModel<ViewState>() {
    override fun initialViewState(): ViewState = ViewState(
        articleContent = "",
        articleDescription = "",
        articleUrlToImage = "",
        articleLink = "",
        articleTitle = ""
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DataEvent.ShowArticle -> {
                return previousState.copy(
                    articleTitle = event.title,
                    articleLink = event.url,
                    articleUrlToImage = event.urlToImage,
                    articleDescription = event.description,
//                    articleContent = event.currentArticle.content?.replace(Regex("\\[.*"),"read full here:")
                )
            }
        }
        return null
    }
}