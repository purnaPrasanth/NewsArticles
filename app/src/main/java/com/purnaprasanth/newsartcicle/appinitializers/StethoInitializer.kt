package com.purnaprasanth.newsartcicle.appinitializers

import android.app.Application
import com.facebook.stetho.Stetho
import com.purnaprasanth.baseandroid.appinitializers.AppInitializer
import javax.inject.Inject


/**
 * Created by purna on 2019-11-09
 **/

class StethoInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        Stetho.initializeWithDefaults(application)
    }
}