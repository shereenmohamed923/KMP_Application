package com.example.kmpapplication.di

fun initKoin() {

    val allModules = sharedKoinModule + databaseModule

    startKoin {
        modules(allModules)
    }
}

class ArticleInjector : KoinComponent {
    val articleViewModel : ArticleViewModel by inject()
}