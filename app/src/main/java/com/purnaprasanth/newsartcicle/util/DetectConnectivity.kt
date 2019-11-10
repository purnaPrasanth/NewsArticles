package com.purnaprasanth.newsartcicle.util

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.purnaprasanth.baseandroid.ConnectivityStatus
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by purna on 2019-11-10
 **/

@Singleton
class DetectConnectivity @Inject constructor(private val application: Application) :
    ConnectivityStatus {

    private val connectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun isConnected(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo

        return activeNetwork?.isConnectedOrConnecting == true
    }
}