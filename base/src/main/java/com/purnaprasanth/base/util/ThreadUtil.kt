package com.purnaprasanth.base.util

import java.util.concurrent.ThreadFactory

/**
 * Created by viking_93 on 2019-11-03
 **/

fun threadFactory(name: String, daemon: Boolean) = ThreadFactory { r ->
    val result = Thread(r, name)
    result.isDaemon = daemon
    result
}