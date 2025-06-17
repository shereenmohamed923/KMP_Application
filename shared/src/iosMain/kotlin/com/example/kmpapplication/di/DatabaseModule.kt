package com.example.kmpapplication.di

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<ArticlesDatabase> { ArticlesDatabase(get()) }
}