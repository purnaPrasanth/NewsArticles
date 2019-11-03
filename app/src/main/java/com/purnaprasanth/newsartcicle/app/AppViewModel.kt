package com.purnaprasanth.newsartcicle.app

import android.app.Application
import com.purnaprasanth.base.AppDispatchers
import com.purnaprasanth.baseandroid.BaseViewModel
import javax.inject.Inject

/**
 * Created by purna on 2019-11-03
 **/

class AppViewModel @Inject constructor(application: Application, appDispatchers: AppDispatchers) :
    BaseViewModel(application, appDispatchers) {
    private val TAG = "AppViewModel"


}