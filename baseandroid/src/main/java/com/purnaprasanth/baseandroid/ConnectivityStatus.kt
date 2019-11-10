package com.purnaprasanth.baseandroid

/**
 * Created by purna on 2019-11-10
 **/

interface ConnectivityStatus {

    /**
     * Method to check internet connectivity
     * Returns true if internet is available,
     * & false if internet not available
     */
    fun isConnected(): Boolean
}