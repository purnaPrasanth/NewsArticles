package com.purnaprasanth.newsartcicle.di

import android.app.Application
import android.content.Context
import com.purnaprasanth.base.annotation.App
import com.purnaprasanth.newsartcicle.NewsArticlesApplication
import dagger.Binds
import dagger.Module

/**
 * Created by purna on 2019-11-03
 **/

@Module
abstract class AppModuleBinds {

    @Binds
    abstract fun bindApplication(application: NewsArticlesApplication): Application

    @Binds
    @App
    abstract fun bindApplicationContext(application: NewsArticlesApplication): Context
}