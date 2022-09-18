package com.example.newsfetcher

import android.util.Log
import androidx.room.Room
import com.example.newsfetcher.base.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL ="https://newsapi.org/"
const val API_KEY = "e7eb5fdff42c4754b8b20f4463995205"
const val APP_DATABASE ="APP_DATABASE"



val netWorkModule = module{

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor { message ->
            Log.d("OkHttp", message)
        }.apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    // Хедер у нас добавляется в OkHttp клиенте - нужен для того чтобы отличать клиентов друг от друга
    // Сейчас мы добавляем API_KEY
    //БЫЛО:
//    single<OkHttpClient> {
//        OkHttpClient
//            .Builder()
//            .addInterceptor(get<HttpLoggingInterceptor>())
//            .build()
//    }

    //Стало:
    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addNetworkInterceptor (HeaderInterceptor())
//            .addNetworkInterceptor {
//                //proceed преобразование
////                it.proceed(it.request().newBuilder().addHeader("x-api-key", API_KEY).build() )
//            }
            // Установка таймаута
//          .callTimeout(25L, TimeUnit.SECONDS)
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

val databaseModule = module {

    single {
        Room
            .databaseBuilder(androidContext(), AppDataBase::class.java, APP_DATABASE)
            .fallbackToDestructiveMigration() //если меняется база данных
            .build()
    }
    single {
        get<AppDataBase>().bookMarksDao()
    }// берем объект из скоупа нашего коина и вызываем функцию запроса, которая нам вернет объект
}