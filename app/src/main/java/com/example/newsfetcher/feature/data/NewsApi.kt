package com.example.newsfetcher.feature.data

import com.example.newsfetcher.API_KEY
import com.example.newsfetcher.feature.data.model.ArticlesRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query
// интерфейс, в котором определена вторая часть пути получения данных, который получает лист типа
// articlesRemoteModel, то есть список статей с сайта
interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getArticles(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("country") country: String = "ru",

    ): ArticlesRemoteModel
}
