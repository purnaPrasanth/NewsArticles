package com.purnaprasanth.base

import kotlinx.coroutines.CoroutineDispatcher


/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * AppDispatchers to be used across app
 * @param mainDispatcher The dispatcher for Operations on Main Thread
 * @param ioDispatcher The dispatcher for IO Operations
 * @param commonDispatcher The Dispatcher for Common Computational Operations
 *
 * Usually created from [AppExecutors]
 */

data class AppDispatchers(
    val mainDispatcher: CoroutineDispatcher,
    val ioDispatcher: CoroutineDispatcher,
    val commonDispatcher: CoroutineDispatcher
)