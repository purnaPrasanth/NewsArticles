package com.purnaprasanth.newsartcicle.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.purnaprasanth.base.annotation.App
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by purna on 2019-11-09
 **/

@Module
class NetworkModule {

    @Singleton
    @Provides
    @App
    fun provideOkhttp(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .callTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addNetworkInterceptor(StethoInterceptor())
        .build()

}