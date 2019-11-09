package com.purnaprasanth.articles.articles.di

import com.purnaprasanth.articles.articles.ArticlesFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by purna on 2019-11-09
 **/

@Subcomponent
interface ArticlesFragmentSubComponent : AndroidInjector<ArticlesFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ArticlesFragment>
}