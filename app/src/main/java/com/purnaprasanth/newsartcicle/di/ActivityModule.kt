package com.purnaprasanth.newsartcicle.di

import com.purnaprasanth.newsartcicle.app.AppActivity
import com.purnaprasanth.newsartcicle.app.AppActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


/**
 * Created by purna on 2019-11-03
 **/

@Module(subcomponents = [AppActivityComponent::class])
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ClassKey(AppActivity::class)
    internal abstract fun bindAppActivity(factory: AppActivityComponent.Factory): AndroidInjector.Factory<*>
}