package com.example.kmpapplication.database

actual class DatabaseDriverFactory() {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = ArticlesDatabase.Schema,
            name = "ArticlesDatabase.database.db"
        )
}