package com.example.kmpapplication.android

import android.app.Application
import com.example.kmpapplication.android.di.viewModelModule
import com.example.kmpapplication.articles.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArticleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        val allModules = sharedKoinModule + viewModelModule
        startKoin {
            androidContext(this@ArticleApplication)
            modules(allModules)
        }
    }
}