package com.purnaprasanth.newsartcicle.app

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by purna on 2019-11-03
 **/

@Subcomponent(
    modules = [
        AppActivityModule::class,
        AppFragmentModule::class
    ]
)
interface AppActivityComponent : AndroidInjector<AppActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<AppActivity>
}