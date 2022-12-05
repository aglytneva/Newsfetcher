package com.example.newsfetcher.feature.articleInfoFragment.di

import com.example.newsfetcher.feature.articleInfoFragment.ArticleInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val articleInfoModule =module {


    viewModel {
        ArticleInfoViewModel()
    }
}