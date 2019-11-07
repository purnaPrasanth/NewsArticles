package com.purna.newsarticles.times

import com.purna.newsarticles.times.services.IArticlesService
import com.purnaprasanth.base.annotation.App
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by purna on 2019-11-04
 **/

class RetrofitServiceProvider @Inject constructor(
    @App retrofit: Retrofit
) : IServiceProvider {
    private val TAG = "RetrofitServiceProvider"

    private val timesRetrofit: Retrofit by lazy {
        retrofit.newBuilder()
            .baseUrl("https://api.nytimes.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override val articleService: IArticlesService by lazy {
        timesRetrofit.create(IArticlesService::class.java)
    }
}