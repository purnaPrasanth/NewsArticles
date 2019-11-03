package com.purnaprasanth.base

import java.util.concurrent.Executor

/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * AppExecutors to be used across App
 * @param mainExecutor The Executor for Operations on Main Thread
 * @param ioExecutor The Executor for IO Operations
 * @param commonExecutor The Executor for Common Computational Operations
 *
 * Usually Used to create [AppDispatchers]
 */
data class AppExecutors(
    val mainExecutor: Executor,
    val ioExecutor: Executor,
    val commonExecutor: Executor
)