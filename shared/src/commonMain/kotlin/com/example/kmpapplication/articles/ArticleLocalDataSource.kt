package com.example.kmpapplication.articles

class ArticleLocalDataSource(
    private val database: ArticlesDatabase
) {
    fun getAllArticles(): List<Article> {
        return database.articleDatabaseQueries.selectAllArticles(::mapToArticle).executeAsList()
    }

    fun insertAllArticles(articles: List<Article>) {
        database.articleDatabaseQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    private fun insertArticle(article: Article) {
        database.articleDatabaseQueries.insertArticle(
            article.title ?: "",
            article.desc,
            article.date ?: "",
            article.imageUrl
        )
    }

    private fun mapToArticle(
        title: String?,
        desc: String?,
        date: String?,
        imgUrl: String?
    ): Article {
        return Article(
            title ?: "",
            desc ?: "",
            date ?: "",
            imgUrl ?: ""
        )
    }

}