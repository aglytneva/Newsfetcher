package com.example.newsfetcher.feature.domain

import com.example.newsfatcher.base.attempt
import com.example.newsfetcher.feature.data.ArticlesRepository
import com.google.gson.Gson

class ArticlesInteractor (private val repository:ArticlesRepository) {
    val gson = Gson()
    suspend fun getArticles () = attempt { repository.getArticles() }
}