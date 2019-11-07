package com.purnaprasanth.base.mvi

import io.reactivex.Observable


/**
 * Created by purna on 2019-11-04
 **/

/**
 * Object that will subscribes to a [MviView]'s [MviIntent]s,
 * process it and emit a [MviViewState] back.
 *
 * @param I Top class of the [MviIntent] that the [MviViewModel] will be subscribing
 * to.
 * @param S Top class of the [MviViewState] the [MviViewModel] will be emitting.
 */
interface MviViewModel<I : MviIntent, S : MviViewState> {
    fun processIntents(intents: Observable<I>)

    fun states(): Observable<S>
}