package com.purnaprasanth.articles.articles

import com.purnaprasanth.base.mvi.MviAction


/**
 * Created by purna on 2019-11-09
 **/

sealed class ArticlesAction : MviAction {
    data class LoadArticlesAction(
        val filter: ArticleFiler
    ) : ArticlesAction()

    data class RefreshArticlesAction(val filter: ArticleFiler) : ArticlesAction()
}