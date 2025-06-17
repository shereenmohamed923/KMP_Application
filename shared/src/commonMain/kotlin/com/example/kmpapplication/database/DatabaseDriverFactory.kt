package com.example.kmpapplication.database

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}