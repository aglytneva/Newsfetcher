//package com.example.newsfetcher.feature.articleInfoFragment
//
//import com.example.newsfatcher.base.BaseViewModel
//import com.example.newsfatcher.base.Event
//
//
//class ArticleScreenViewModel() : BaseViewModel<ViewState>() {
//
//
//    override fun initialViewState(): ViewState = ViewState(
//        author = "",
//        title ="",
//        description ="" ,
//        url ="",
//        urlToImage ="",
//        publishedAt ="",
//        content = ""
//    )
//
//    override fun reduce(event: Event, previousState: ViewState): ViewState? {
//
//        when (event) {
//            is DataEvent.ShowArticle -> {
//                return previousState.copy(
////                    author= event.currentArticle.author,
//                    title = event.title,
////                    description = event.currentArticle.description,
////                    url = event.currentArticle.url,
////                    urlToImage = event.currentArticle.urlToImage,
////                    publishedAt = event.currentArticle.publishedAt,
////                    content = event.currentArticle.content
//                )
//            }
//        }
//        return null
//    }
//}