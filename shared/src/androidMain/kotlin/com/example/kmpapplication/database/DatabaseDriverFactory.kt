package com.example.kmpapplication.database

actual class DatabaseDriverFactory(
    private val context:Context
) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = ArticlesDatabase.Schema,
            context = context,
            name = "ArticlesDatabase.database.db"
        )
}