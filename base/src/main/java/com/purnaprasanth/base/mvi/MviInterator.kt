package com.purnaprasanth.base.mvi

import io.reactivex.ObservableTransformer

/**
 * Created by purna on 2019-11-09
 **/

interface MviInterator<ACTION : MviAction, RESULT : MviResult> {
    fun actionInteractor(): ObservableTransformer<ACTION, RESULT>
}