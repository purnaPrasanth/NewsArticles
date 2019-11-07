package com.purnaprasanth.newsarticles.data.datasources

import com.purnaprasanth.newsarticles.data.model.ArticleDetail
import io.reactivex.Observable

/**
 * Created by purna on 2019-11-04
 **/

interface IArticleDataSource {

    fun getArticles(section: String): Observable<List<ArticleDetail>>

}