package com.purnaprasanth.newsartcicle.app

import androidx.lifecycle.ViewModel
import com.purnaprasanth.base.AppRxSchedulers
import javax.inject.Inject

/**
 * Created by purna on 2019-11-03
 **/

class AppViewModel @Inject constructor(
    private val appRxSchedulers: AppRxSchedulers
) : ViewModel() {
    private val TAG = "AppViewModel"


}