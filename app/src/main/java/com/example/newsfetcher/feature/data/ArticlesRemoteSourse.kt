package com.example.newsfetcher.feature.data

import com.example.newsfetcher.feature.data.model.ArticlesRemoteModel
// класс, получающий апи, и формирующий запрос (адресную строку)
class ArticlesRemoteSourse (private val api : NewsApi) {

    suspend fun getArticles () : ArticlesRemoteModel {
        return api.getArticles()
    }
}