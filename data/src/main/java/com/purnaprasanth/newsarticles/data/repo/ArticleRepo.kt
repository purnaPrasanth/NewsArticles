package com.purnaprasanth.newsarticles.data.repo

import com.purnaprasanth.newsarticles.data.datasources.IArticleDataSource
import javax.inject.Inject

/**
 * Created by purna on 2019-11-04
 **/

class ArticleRepo @Inject constructor(
    private val remoteArticleDataSource: IArticleDataSource
) {
    private val TAG = "ArticleRepo"

    fun syncArticleList(section: String) {
        TODO()
    }

    fun observeArticleList(section: String) = remoteArticleDataSource.getArticles(section)
}