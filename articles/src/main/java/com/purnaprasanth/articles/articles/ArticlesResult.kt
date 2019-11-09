package com.purnaprasanth.articles.articles

import com.purnaprasanth.base.mvi.MviResult
import com.purnaprasanth.newsarticles.data.model.ArticleDetail

/**
 * Created by purna on 2019-11-09
 **/

sealed class ArticlesResult : MviResult {

    sealed class LoadArticlesResult : ArticlesResult() {
        data class Success(val tasks: List<ArticleDetail>, val articleFiler: ArticleFiler) :
            LoadArticlesResult()

        data class Failure(val error: Throwable) : LoadArticlesResult()
        object Loading : LoadArticlesResult()
    }

    sealed class RefreshArticlesResult : ArticlesResult() {
        data class Success(val tasks: List<ArticleDetail>) : RefreshArticlesResult()
        data class Failure(val error: Throwable) : RefreshArticlesResult()
        object Loading : RefreshArticlesResult()
    }
}