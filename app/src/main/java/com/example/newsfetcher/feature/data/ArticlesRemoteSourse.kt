package com.example.newsfetcher.feature.data

import com.example.newsfetcher.feature.data.model.ArticleRemoteModel
import com.example.newsfetcher.feature.data.model.ArticlesRemoteModel

class ArticlesRemoteSourse (private val api : NewsApi) {

    suspend fun getArticles () : ArticlesRemoteModel {
        return api.getArticles()
    }
}