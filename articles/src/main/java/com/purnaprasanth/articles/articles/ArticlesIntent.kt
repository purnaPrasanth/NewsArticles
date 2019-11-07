package com.purnaprasanth.articles.articles

import com.purnaprasanth.base.mvi.MviIntent


/**
 * Created by purna on 2019-11-05
 **/

sealed class ArticlesIntent : MviIntent {

    data class ChangeFilterIntent(val newSection: String) : ArticlesIntent()
}