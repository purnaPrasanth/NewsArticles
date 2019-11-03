package com.purnaprasanth.newsartcicle.di

import com.purnaprasanth.newsartcicle.NewsArticlesApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by viking_93 on 2019-11-03
 **/

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        AppModule::class,
        ExecutorModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<NewsArticlesApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: NewsArticlesApplication): AppComponent
    }
}