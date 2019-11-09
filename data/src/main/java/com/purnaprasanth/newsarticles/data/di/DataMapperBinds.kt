package com.purnaprasanth.newsarticles.data.di

import com.purna.newsarticles.times.model.Article
import com.purnaprasanth.newsarticles.data.Mapper
import com.purnaprasanth.newsarticles.data.mappers.RemoteArticleToLocalArticle
import com.purnaprasanth.newsarticles.data.model.ArticleDetail
import dagger.Binds
import dagger.Module


/**
 * Created by purna on 2019-11-09
 **/

@Module
abstract class DataMapperBinds {
    private val TAG = "DataMapperBinds"

    @Binds
    abstract fun bindArticlesMapper(articlesMapper: RemoteArticleToLocalArticle): Mapper<Article, ArticleDetail>
}