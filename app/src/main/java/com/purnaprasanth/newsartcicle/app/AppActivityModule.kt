package com.purnaprasanth.newsartcicle.app

import dagger.Module


/**
 * Created by purna on 2019-11-03
 **/

@Module(
    includes = [
        AppActivityBinds::class
    ]
)
class AppActivityModule