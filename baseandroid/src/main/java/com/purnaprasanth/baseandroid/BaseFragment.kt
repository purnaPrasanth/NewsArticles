package com.purnaprasanth.baseandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


/**
 * Created by viking_93 on 2019-11-03
 **/

abstract class BaseFragment<BINDING : ViewDataBinding>(@LayoutRes val layId: Int) :
    DaggerFragment(), CoroutineScope {
    private lateinit var bindingInternal: BINDING
    val binding: BINDING
        get() = bindingInternal

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingInternal = DataBindingUtil.inflate(inflater, layId, container, false)
        bindingInternal.lifecycleOwner = this
        initUI()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        job.cancel()
    }

    abstract fun initUI()
}