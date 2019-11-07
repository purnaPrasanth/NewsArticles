package com.purnaprasanth.newsartcicle.di

import com.purnaprasanth.base.AppRxSchedulers
import com.purnaprasanth.base.annotation.Common
import com.purnaprasanth.base.annotation.IO
import com.purnaprasanth.base.annotation.Main
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * Created by purna on 2019-11-03
 **/

@Module
class ExecutorModule {

    @Provides
    @Singleton
    fun provideRxScedulers() = AppRxSchedulers(
        mainScheduler = AndroidSchedulers.mainThread(), // change it to main
        ioScheduler = Schedulers.io(),
        commonScheduler = Schedulers.computation()
    )

    @Provides
    @IO
    fun provideIOExecutor(appRxSchedulers: AppRxSchedulers) = appRxSchedulers.ioScheduler

    @Provides
    @Common
    fun provideCommonExecutor(appRxSchedulers: AppRxSchedulers) = appRxSchedulers.commonScheduler

    @Provides
    @Main
    fun provideMainExecutor(appRxSchedulers: AppRxSchedulers) = appRxSchedulers.mainScheduler
}