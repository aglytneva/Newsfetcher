package com.example.newsfetcher.feature.data

import com.example.newsfetcher.SimpleModel
import com.example.newsfetcher.feature.data.model.ArticlesRemoteModel
import retrofit2.http.*

// интерфейс, в котором определена вторая часть пути получения данных, который получает лист типа
// articlesRemoteModel, то есть список статей с сайта
interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getArticles(
       //После добавления хедера с  API_KEY строка становится ненужной
       // @Query("apiKey") apiKey: String = API_KEY,
        @Query("country") country: String = "ru",
    ): ArticlesRemoteModel

    //Постзапрос пример
    // поле country будет теперь не в заголовке, а  в теле запроса и оно
    @FormUrlEncoded // специальная аннотация, которая шифрует тело запроса
    @POST("v2/top-headlines")
    suspend fun postArticles(
        //После добавления хедера с  API_KEY строка становится ненужной
        // @Query("apiKey") apiKey: String = API_KEY,
        @Field("country") country: String = "ru",

        ): ArticlesRemoteModel

    //Постзапрос пример 2
    // Не просто передать параметры, а сформировать тело запроса
    @POST("v2/top-headlines")
    suspend fun postArticlesBody(
        //Body - это объект класа который надо передать, синтетическ
        @Body simpleModel: SimpleModel= SimpleModel("ru", 5, listOf("GGG", "hhh", "ddd") )
        ): ArticlesRemoteModel
}
