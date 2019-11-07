package com.purnaprasanth.newsarticles.data.datasources

import com.purna.newsarticles.times.model.Article
import com.purna.newsarticles.times.services.IArticlesService
import com.purnaprasanth.newsarticles.data.Mapper
import com.purnaprasanth.newsarticles.data.model.ArticleDetail
import com.purnaprasanth.newsarticles.data.toListMapper
import io.reactivex.Observable

/**
 * Created by purna on 2019-11-04
 **/

class RemoteArticleDataSource(
    private val articleService: IArticlesService,
    private val articleListMapper: Mapper<Article, ArticleDetail>,
    private val articleDetailMapper: Mapper<Article, ArticleDetail>
) : IArticleDataSource {

    override fun getArticles(section: String): Observable<List<ArticleDetail>> {
        return articleService.getArticles(section).map {
            articleListMapper.toListMapper().map(it.results)
        }
    }

    private val TAG = "RemoteArticleDataSource"


}