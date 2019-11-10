package com.purnaprasanth.articles.navigation

import com.purnaprasanth.newsarticles.data.model.ArticleDetail

/**
 * Created by purna on 2019-11-10
 **/

interface IArticlesNavigation {
    fun viewArticleDetails(articleDetail: ArticleDetail)
}