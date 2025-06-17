package com.example.kmpapplication.articles

class ArticleRepository(
    private val service: ArticleService,
    private val database: ArticleLocalDataSource
) {

    suspend fun getArticles(): List<Article> {
        val articlesDb = database.getAllArticles()
        if (articlesDb.isEmpty()){
            val fetchedArticle = service.fetchArticles()
            database.insertAllArticles(fetchedArticle)
            return fetchedArticle
        }
        return articlesDb
    }

}