package com.purnaprasanth.newsartcicle.app

import com.purnaprasanth.articles.articledetail.ArticleDetailFragment
import com.purnaprasanth.articles.articledetail.ArticleDetailSubComponent
import com.purnaprasanth.articles.articles.ArticlesFragment
import com.purnaprasanth.articles.articles.di.ArticlesFragmentSubComponent
import com.purnaprasanth.newsarticles.data.model.ArticleDetail
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
        ArticlesFragmentSubComponent::class,
        ArticleDetailSubComponent::class
    ]
)
internal abstract class AppFragmentModule {
    @Binds
    @IntoMap
    @ClassKey(ArticlesFragment::class)
    internal abstract fun bindArticleFragmentInjectorFactory(factory: ArticlesFragmentSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(ArticleDetailFragment::class)
    internal abstract fun bindArticleDetailFragmentInjectorFactory(factory: ArticleDetailSubComponent.Factory): AndroidInjector.Factory<*>
}