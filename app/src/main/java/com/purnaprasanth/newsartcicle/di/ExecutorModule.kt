package com.purnaprasanth.newsartcicle.di

import com.purnaprasanth.base.AppDispatchers
import com.purnaprasanth.base.AppExecutors
import com.purnaprasanth.baseandroid.annotation.Common
import com.purnaprasanth.baseandroid.annotation.IO
import com.purnaprasanth.baseandroid.annotation.Main
import com.purnaprasanth.baseandroid.async.CommonExecutor
import com.purnaprasanth.baseandroid.async.IOExecutor
import com.purnaprasanth.baseandroid.async.MainThreadExecutor
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.asCoroutineDispatcher
import javax.inject.Singleton

/**
 * Created by purna on 2019-11-03
 **/

@Module
class ExecutorModule {

    @Provides
    @Singleton
    fun provideAppExecutors(
        mainExecutor: MainThreadExecutor,
        ioExecutor: IOExecutor,
        commonExecutor: CommonExecutor
    ) = AppExecutors(
        mainExecutor = mainExecutor.executor,
        ioExecutor = ioExecutor.executor,
        commonExecutor = commonExecutor.executor
    )

    @Provides
    @Singleton
    fun provideAppDispatchers(appExecutors: AppExecutors) = AppDispatchers(
        mainDispatcher = appExecutors.mainExecutor.asCoroutineDispatcher(),
        ioDispatcher = appExecutors.ioExecutor.asCoroutineDispatcher(),
        commonDispatcher = appExecutors.commonExecutor.asCoroutineDispatcher()
    )

    @Provides
    @IO
    fun provideIODispatcher(appDispatchers: AppDispatchers) = appDispatchers.ioDispatcher

    @Provides
    @Common
    fun provideCommonDispatcher(appDispatchers: AppDispatchers) = appDispatchers.commonDispatcher

    @Provides
    @Main
    fun provideMainDispatcher(appDispatchers: AppDispatchers) = appDispatchers.mainDispatcher

    @Provides
    @IO
    fun provideIOExecutor(appExecutors: AppExecutors) = appExecutors.ioExecutor

    @Provides
    @Common
    fun provideCommonExecutor(appExecutors: AppExecutors) = appExecutors.commonExecutor

    @Provides
    @Main
    fun provideMainExecutor(appExecutors: AppExecutors) = appExecutors.mainExecutor
}