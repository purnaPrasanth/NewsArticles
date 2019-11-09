package com.purnaprasanth.newsarticles.data.di

import com.purna.newsarticles.times.di.TimeModule
import com.purna.newsarticles.times.di.TimesModuleBinds
import com.purnaprasanth.base.annotation.Local
import com.purnaprasanth.base.annotation.Times
import com.purnaprasanth.newsarticles.data.datasources.IArticleDataSource
import com.purnaprasanth.newsarticles.data.datasources.RemoteArticleDataSource
import dagger.Binds
import dagger.Module


/**
 * Created by purna on 2019-11-09
 **/

@Module
abstract class DataSourceBinds {
    private val TAG = "DataSourceBinds"

    @Binds
    @Times
    abstract fun bindRemoteDataSource(remoteArticleDataSource: RemoteArticleDataSource): IArticleDataSource
}