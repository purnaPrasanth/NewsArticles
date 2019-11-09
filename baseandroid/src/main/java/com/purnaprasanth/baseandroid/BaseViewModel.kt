package com.purnaprasanth.baseandroid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.purnaprasanth.base.AppRxSchedulers
import com.purnaprasanth.base.mvi.MviIntent
import com.purnaprasanth.base.mvi.MviViewModel
import com.purnaprasanth.base.mvi.MviViewState
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject


/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * Base Class for ViewModel
 */

abstract class BaseViewModel<MVI_INTENT : MviIntent, VIEW_STATE : MviViewState>(
    protected val appRxSchedulers: AppRxSchedulers
) : ViewModel(), MviViewModel<MVI_INTENT, VIEW_STATE> {

    protected val intentsSubject: PublishSubject<MVI_INTENT> = PublishSubject.create()

    protected val statesObservable: Observable<VIEW_STATE> by lazy {
        compose()
    }

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun processIntents(intents: Observable<MVI_INTENT>) {
        compositeDisposable.add(intents.subscribe(intentsSubject::onNext))
    }

    override fun states() = statesObservable

    abstract fun compose(): Observable<VIEW_STATE>

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


}