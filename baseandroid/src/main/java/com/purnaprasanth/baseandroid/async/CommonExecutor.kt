package com.purnaprasanth.baseandroid.async

import android.os.AsyncTask
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * Executor for Common Computational tasks
 */

@Singleton
class CommonExecutor @Inject constructor() : AppExecutor {
    override val executor: Executor
        get() = AsyncTask.THREAD_POOL_EXECUTOR
}