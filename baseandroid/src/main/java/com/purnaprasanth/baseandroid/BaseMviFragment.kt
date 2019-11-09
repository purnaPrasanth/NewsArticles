package com.purnaprasanth.baseandroid

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.purnaprasanth.base.mvi.MviIntent
import com.purnaprasanth.base.mvi.MviView
import com.purnaprasanth.base.mvi.MviViewState
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by viking_93 on 2019-11-03
 **/

abstract class BaseMviFragment<BINDING : ViewDataBinding, MVI_INTENT : MviIntent, VIEW_STATE : MviViewState, VIEW_MODEL : BaseViewModel<MVI_INTENT, VIEW_STATE>>(
    @LayoutRes layId: Int,
    viewModelClass: Class<VIEW_MODEL>
) : BaseFragment<BINDING>(layId), MviView<MVI_INTENT, VIEW_STATE> {

    protected val viewModel: VIEW_MODEL by lazy {
        viewModelProvider[viewModelClass]
    }

    private val compositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    @CallSuper
    open fun bind() {
        // Subscribe to the ViewModel and call render for every emitted state
        compositeDisposable.add(viewModel.states().subscribe(this::render))
        // Pass the UI's intents to the ViewModel
        viewModel.processIntents(intents())
    }
}