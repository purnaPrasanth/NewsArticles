package com.purnaprasanth.baseandroid.async

import java.util.concurrent.Executor


/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * Base Executor
 */

interface AppExecutor {
    val executor: Executor
}