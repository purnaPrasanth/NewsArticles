package com.purna.newsarticles.times

import com.purna.newsarticles.times.services.IArticlesService


/**
 * Created by purna on 2019-11-04
 **/

interface IServiceProvider {

    val articleService: IArticlesService
}