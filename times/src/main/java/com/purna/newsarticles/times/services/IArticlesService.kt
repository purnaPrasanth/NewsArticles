package com.purna.newsarticles.times.services

import com.purna.newsarticles.times.model.Article
import com.purna.newsarticles.times.model.ListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by purna on 2019-11-04
 **/

interface IArticlesService {

    @GET("/svc/topstories/v2/{section}.json")
    fun getArticles(@Path("section") section: String): Observable<ListResponse<Article>>
}