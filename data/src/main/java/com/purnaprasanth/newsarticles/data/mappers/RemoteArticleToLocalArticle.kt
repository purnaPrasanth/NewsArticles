package com.purnaprasanth.newsarticles.data.mappers

import com.purna.newsarticles.times.model.Article
import com.purnaprasanth.newsarticles.data.Mapper
import com.purnaprasanth.newsarticles.data.model.ArticleDetail
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by purna on 2019-11-09
 **/

@Singleton
class RemoteArticleToLocalArticle @Inject constructor() : Mapper<Article, ArticleDetail> {
    private val TAG = "RemoteArticleToLocalArticle"

    override fun map(from: Article) = ArticleDetail(
        id = 0L,
        title = from.title,
        coverImage = from.multimedia.find { it.format == "superJumbo" }?.url.orEmpty(),
        abstract = from.abstract,
        articleLink = from.url,
        authorName = from.byline,
        publishData = from.createdDate,
        section = from.section
    )
}