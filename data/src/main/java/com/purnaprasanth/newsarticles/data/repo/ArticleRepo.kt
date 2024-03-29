package com.purnaprasanth.newsarticles.data.repo

import com.purnaprasanth.base.annotation.Local
import com.purnaprasanth.base.annotation.Times
import com.purnaprasanth.newsarticles.data.datasources.IArticleDataSource
import com.purnaprasanth.newsarticles.data.db.ArticlesDatabase
import com.purnaprasanth.newsarticles.data.model.ArticleDetail
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by purna on 2019-11-04
 **/

class ArticleRepo @Inject constructor(
    @Times private val remoteArticleDataSource: IArticleDataSource,
    @Local private val localArticleDataSource: IArticleDataSource,
    private val dataBase: ArticlesDatabase
) {
    private val TAG = "ArticleRepo"

    fun getArticles(section: String, fromServer: Boolean): Observable<List<ArticleDetail>> {
        return if (fromServer) {
            remoteArticleDataSource.getArticles(section).map {
                dataBase.articleDao().insertAll(it)
                it
            }
        } else {
            localArticleDataSource.getArticles(section)
        }
    }
}