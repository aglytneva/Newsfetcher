package com.example.newsfetcher.feature.domain

import com.example.newsfatcher.base.attempt
import com.example.newsfetcher.feature.data.ArticlesRepository

class ArticlesInteractor (private val repository:ArticlesRepository) {

    suspend fun getArticles () = attempt { repository.getArticles() }
}