package com.purnaprasanth.newsartcicle.di

import android.app.Application
import android.content.Context
import com.purnaprasanth.articles.articles.ArticlesAction
import com.purnaprasanth.articles.articles.ArticlesInteractor
import com.purnaprasanth.articles.articles.ArticlesResult
import com.purnaprasanth.base.annotation.App
import com.purnaprasanth.base.mvi.MviInterator
import com.purnaprasanth.baseandroid.appinitializers.AppInitializer
import com.purnaprasanth.newsartcicle.NewsArticlesApplication
import com.purnaprasanth.newsartcicle.appinitializers.StethoInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

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


    @Binds
    abstract fun bindArticlesInteractor(articlesInteractor: ArticlesInteractor): MviInterator<ArticlesAction, ArticlesResult>

    @IntoSet
    @Binds
    abstract fun bindStethoInitilizers(stethoInitializer: StethoInitializer): AppInitializer
}