package com.purnaprasanth.baseandroid.appinitializers

import android.app.Application


/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * Base Class For App Initializer
 */

interface AppInitializer {
    fun init(application: Application)
}