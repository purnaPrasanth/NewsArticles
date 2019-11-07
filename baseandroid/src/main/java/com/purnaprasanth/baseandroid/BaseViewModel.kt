package com.purnaprasanth.baseandroid

import android.app.Application
import androidx.lifecycle.AndroidViewModel


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

open class BaseViewModel(application: Application) :
    AndroidViewModel(application) {
}