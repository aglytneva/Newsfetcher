package com.example.newsfetcher

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.newsfetcher.feature.bookmarks.di.boomarksModule
import com.example.newsfetcher.feature.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application () {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
            startKoin {
                androidLogger()
                androidContext(this@App)
                modules(netWorkModule, mainScreenModule,databaseModule, boomarksModule)
        }

        // Чтобы приложение использовало темную тему в зависимости от системы

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }
}