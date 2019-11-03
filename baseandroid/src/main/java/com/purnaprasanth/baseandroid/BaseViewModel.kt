package com.purnaprasanth.baseandroid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.purnaprasanth.base.AppDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.util.concurrent.CancellationException
import kotlin.coroutines.CoroutineContext


/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * Base Class for ViewModel
 *
 * This also extends [CoroutineScope], hence acts as a parent for all the coRoutines started in this activity scope or Lifecycle
 *
 * @property parentJob parent job for the coRoutines started in this scope
 */

open class BaseViewModel(application: Application, protected val appDispatchers: AppDispatchers) :
    AndroidViewModel(application), CoroutineScope {
    private val parentJob = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = parentJob + appDispatchers.ioDispatcher

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel(CancellationException("Parent Scope Destroyed"))
    }
}