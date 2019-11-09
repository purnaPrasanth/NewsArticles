package com.purna.newsarticles.times.di

import com.purna.newsarticles.times.IServiceProvider
import com.purna.newsarticles.times.services.IArticlesService
import dagger.Module
import dagger.Provides

/**
 * Created by purna on 2019-11-09
 **/

@Module(includes = [TimesModuleBinds::class])
class TimeModule {

    @Provides
    fun provideArticlesService(serviceProvider: IServiceProvider): IArticlesService =
        serviceProvider.articleService
}