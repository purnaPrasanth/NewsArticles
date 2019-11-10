package com.purnaprasanth.newsartcicle.app

import android.app.Activity
import android.content.Context
import com.purnaprasanth.articles.articles.ArticlesAction
import com.purnaprasanth.articles.articles.ArticlesInteractor
import com.purnaprasanth.articles.articles.ArticlesResult
import com.purnaprasanth.articles.navigation.IArticlesNavigation
import com.purnaprasanth.base.mvi.MviInterator
import dagger.Binds
import dagger.Module


/**
 * Created by purna on 2019-11-03
 **/

@Module
abstract class AppActivityBinds {

    @Binds
    abstract fun provideActivityContext(activity: AppActivity): Context

    @Binds
    abstract fun provideActivity(activity: AppActivity): Activity

    @Binds
    abstract fun provideArticlesNavigator(appActivity: AppActivity): IArticlesNavigation
}