package com.example.newsfetcher

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL ="https://newsapi.org/"
const val API_KEY = "e7eb5fdff42c4754b8b20f4463995205"

val appModule = module{
    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .addInterceptor(
               HttpLoggingInterceptor{ message ->
                   Log.d("OkHttp",message)
               }.apply { 
                   setLevel(HttpLoggingInterceptor.Level.BODY)
               }
                
            )
            .build()
    }

    //создаем сам ретрофит
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
}