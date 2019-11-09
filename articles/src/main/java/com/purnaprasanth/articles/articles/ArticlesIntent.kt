package com.purnaprasanth.articles.articles

import com.purnaprasanth.base.mvi.MviIntent


/**
 * Created by purna on 2019-11-05
 **/

sealed class ArticlesIntent : MviIntent {

    object InitialIntent : ArticlesIntent()

    data class ChangeFilterIntent(val newFilter: ArticleFiler) : ArticlesIntent()

    data class RefreshArticlesIntent(val newFilter: ArticleFiler) : ArticlesIntent()
}