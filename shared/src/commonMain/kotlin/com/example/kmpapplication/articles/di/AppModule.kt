package com.example.kmpapplication.articles.di

import com.example.kmpapplication.articles.ArticleRepository
import com.example.kmpapplication.articles.ArticleService
import com.example.kmpapplication.articles.ArticleViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}

val articleModule = module {
    single { ArticleService(get()) }
    single { ArticleLocalDataSource(get()) }
    single { ArticleRepository(get())}
    single { ArticleViewModel(get())}
}

val sharedKoinModule = networkModule + articleModule

