package com.purna.newsarticles.times

import com.purna.newsarticles.times.services.IArticlesService
import com.purnaprasanth.base.annotation.App
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by purna on 2019-11-04
 **/

class RetrofitServiceProvider @Inject constructor(
    @App okHttp: OkHttpClient
) : IServiceProvider {
    private val TAG = "RetrofitServiceProvider"

    private val timesOkHttp = okHttp.newBuilder()
        .addInterceptor(AutherizationInterceptor)
        .build()

    private val timesRetrofit = Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/")
        .client(timesOkHttp)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override val articleService: IArticlesService by lazy {
        timesRetrofit.create(IArticlesService::class.java)
    }

    companion object AutherizationInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val newUrl = chain.request().url.newBuilder().apply {
                addQueryParameter("api-key", "xI4AA4gcMj9JyFlyQn2dSAj689PGjKjA")
            }.build()
            return chain.proceed(chain.request().newBuilder().apply { url(newUrl) }.build())
        }

    }
}