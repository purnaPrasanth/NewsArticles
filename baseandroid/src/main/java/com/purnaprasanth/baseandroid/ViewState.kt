package com.purnaprasanth.baseandroid

/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * Base class for states of a View
 * @param T the data that this is holding
 */
sealed class ViewState<T> {
    abstract fun get(): T?
}

/**
 * Success implementation for state of a View [ViewState]
 * @param T data that this Success result holds
 */
data class SuccessViewState<T>(val data: T) : ViewState<T>() {
    override fun get(): T = data
}

/**
 * Error implementation for state of a View [ViewState]
 * @param exception Error Details for Failure
 */
data class ErrorViewState<T>(
    val exception: Exception,
    val message: String
) : ViewState<T>() {
    override fun get(): Nothing? = null
}

/**
 * Loading implementation for state of a View [ViewState]
 */
data class LoadingViewState<T>(val data: Nothing? = null) : ViewState<T>() {
    override fun get(): Nothing? = null
}