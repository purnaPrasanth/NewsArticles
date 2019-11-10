package com.purnaprasanth.newsarticles.data.datasources

import com.purnaprasanth.newsarticles.data.db.ArticlesDatabase
import com.purnaprasanth.newsarticles.data.model.ArticleDetail
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by purna on 2019-11-10
 **/

class LocalArticleDataSource @Inject constructor(
    private val database: ArticlesDatabase
) : IArticleDataSource {
    override fun getArticles(section: String): Observable<List<ArticleDetail>> {
        return database.articleDao().observeArticles(section)
    }
}