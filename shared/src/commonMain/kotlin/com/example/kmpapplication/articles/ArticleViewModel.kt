package com.example.kmpapplication.articles

import com.example.kmpapplication.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(
    private var repo: ArticleRepository
) : BaseViewModel() {
    private var _articleStates: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))
    val articleState = _articleStates.asStateFlow()

    init {
        getAllArticles()
    }

    private fun getAllArticles() {
        scope.launch {
            val articlesData = repo.fetchData()
            _articleStates.emit(ArticlesState(articles = articlesData))
        }
    }

}

