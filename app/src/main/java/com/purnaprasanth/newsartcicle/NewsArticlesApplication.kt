package com.purnaprasanth.newsartcicle

import com.purnaprasanth.baseandroid.appinitializers.AppInitializers
import com.purnaprasanth.newsartcicle.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

/**
 * Created by viking_93 on 2019-11-03
 **/

class NewsArticlesApplication : DaggerApplication() {
    @Inject
    lateinit var appInitializers: AppInitializers

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        appInitializers.init(this)
    }

}