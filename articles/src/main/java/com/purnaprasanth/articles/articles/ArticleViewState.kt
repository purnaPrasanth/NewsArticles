package com.purnaprasanth.articles.articles

import com.purnaprasanth.base.mvi.MviViewState
import com.purnaprasanth.newsarticles.data.model.ArticleDetail

/**
 * Created by purna on 2019-11-05
 **/

data class ArticlesViewState(
    val isLoading: Boolean,
    val articles: List<ArticleDetail>,
    val error: Throwable?,
    val articleFilter: ArticleFiler
) : MviViewState {
    companion object {
        fun initial() = ArticlesViewState(
            isLoading = false,
            articles = emptyList(),
            error = null,
            articleFilter = ArticleFiler.Science
        )
    }
}

enum class ArticleFiler(val value: String) {
    Science("science"),
    Technology("technology"),
    Business("business"),
    World("world"),
    Movies("movies"),
    Travel("travel")
}