package com.purnaprasanth.baseandroid.appinitializers

import android.app.Application
import javax.inject.Inject


/**
 * Created by viking_93 on 2019-11-03
 **/

class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}