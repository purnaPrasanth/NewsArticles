package com.purnaprasanth.newsartcicle.app

import com.purnaprasanth.articles.articles.ArticlesFragment
import com.purnaprasanth.articles.articles.di.ArticlesFragmentSubComponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module

/**
 * Created by purna on 2019-11-09
 **/

@Module(
    subcomponents = [
        ArticlesFragmentSubComponent::class
    ]
)
internal abstract class AppFragmentModule {
    @Binds
    @IntoMap
    @ClassKey(ArticlesFragment::class)
    internal abstract fun bindArticleFragmentInjectorFactory(factory: ArticlesFragmentSubComponent.Factory): AndroidInjector.Factory<*>
}