package com.purna.newsarticles.times.di

import com.purna.newsarticles.times.IServiceProvider
import com.purna.newsarticles.times.RetrofitServiceProvider
import dagger.Binds
import dagger.Module


/**
 * Created by purna on 2019-11-09
 **/

@Module
abstract class TimesModuleBinds {
    private val TAG = "TimesModuleBinds"

    @Binds
    abstract fun bindServiceProvider(retrofitServiceProvider: RetrofitServiceProvider): IServiceProvider
}