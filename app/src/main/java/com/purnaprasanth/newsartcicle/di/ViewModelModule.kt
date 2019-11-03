package com.purnaprasanth.newsartcicle.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.purnaprasanth.baseandroid.ViewModelFactory
import com.purnaprasanth.baseandroid.annotation.ViewModelKey
import com.purnaprasanth.newsartcicle.app.AppViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by purna on 2019-11-03
 **/

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AppViewModel::class)
    abstract fun provideAppViewModel(viewModel: AppViewModel): ViewModel
}