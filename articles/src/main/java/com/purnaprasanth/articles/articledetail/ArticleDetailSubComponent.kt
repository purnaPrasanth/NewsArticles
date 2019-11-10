package com.purnaprasanth.articles.articledetail

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by purna on 2019-11-10
 **/

@Subcomponent
interface ArticleDetailSubComponent : AndroidInjector<ArticleDetailFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ArticleDetailFragment>
}