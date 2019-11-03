package com.purnaprasanth.newsartcicle.di

import android.app.Application
import android.content.Context
import com.purnaprasanth.baseandroid.annotation.App
import com.purnaprasanth.newsartcicle.NewsArticlesApplication
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Singleton


/**
 * Created by purna on 2019-11-03
 **/

@Module(includes = [AppModuleBinds::class])
class AppModule