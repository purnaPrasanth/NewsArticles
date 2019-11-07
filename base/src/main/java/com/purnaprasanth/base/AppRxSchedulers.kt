package com.purnaprasanth.base

import io.reactivex.Scheduler


/**
 * Created by purna on 2019-11-04
 **/

data class AppRxSchedulers(
    val mainScheduler: Scheduler,
    val commonScheduler: Scheduler,
    val ioScheduler: Scheduler
)