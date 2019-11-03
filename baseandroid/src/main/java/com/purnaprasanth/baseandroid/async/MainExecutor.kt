package com.purnaprasanth.baseandroid.async

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * Executor for Main Thread Tasks
 */

@Singleton
class MainThreadExecutor @Inject constructor() : AppExecutor {
    override val executor: Executor
        get() = _executor

    private val _executor = object : Executor {
        override fun execute(runnable: Runnable?) {
            if (runnable == null) return
            MainHandler.INSTANCE.handler.post(runnable)
        }
    }
}

private class MainHandler private constructor() {

    val handler = Handler(Looper.getMainLooper())

    companion object {
        val INSTANCE: MainHandler by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { MainHandler() }
    }
}