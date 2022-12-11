package com.example.newsfetcher.feature.bookmarks.di

import com.example.newsfetcher.feature.bookmarks.data.local.BookmaksLocalSourse
import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksRepository
import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksRepositoryImpl
import com.example.newsfetcher.feature.bookmarks.domain.BookmarksInteractor
import com.example.newsfetcher.feature.bookmarks.ui.BookmarksScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sin

const val BOOKMARKS_TABLE ="BOOKMARKS_TABLE"

val boomarksModule =module {

    single {
        BookmaksLocalSourse(bookmarksDao = get ())

    }
    single <BookmarksRepository> {
        BookmarksRepositoryImpl(bookmaksLocalSourse = get())

    }

    single {
        BookmarksInteractor (bookmarksRepository =get())
    }

    viewModel {
        BookmarksScreenViewModel(interactor = get())
    }
}