package com.example.newsfetcher.feature.di

import com.example.newsfetcher.feature.data.ArticlesRemoteSourse
import com.example.newsfetcher.feature.data.ArticlesRepository
import com.example.newsfetcher.feature.data.ArticlesRepositoryImpl
import com.example.newsfetcher.feature.data.NewsApi
import com.example.newsfetcher.feature.domain.ArticlesInteractor
import com.example.newsfetcher.feature.mainscreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainScreenModule = module {
    single <NewsApi> {
        get <Retrofit>().create(NewsApi::class.java)
    }

    single <ArticlesRemoteSourse>{
        ArticlesRemoteSourse (api = get())
    }

    single <ArticlesRepository> {
        ArticlesRepositoryImpl (source = get())

    }

    single<ArticlesInteractor> {
        ArticlesInteractor( repository = get())
    }
    viewModel {
        MainScreenViewModel (interactor = get(), bookmarksInteractor = get())
    }
}