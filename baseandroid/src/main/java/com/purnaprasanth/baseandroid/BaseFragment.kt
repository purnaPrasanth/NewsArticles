package com.purnaprasanth.baseandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.purnaprasanth.base.AppDispatchers
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by viking_93 on 2019-11-03
 **/

abstract class BaseFragment<BINDING : ViewDataBinding>(@LayoutRes val layId: Int) :
    DaggerFragment(), CoroutineScope {

    private lateinit var _binding: BINDING

    protected val binding: BINDING
        get() = _binding

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = job + appDispatchers.mainDispatcher

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appDispatchers: AppDispatchers

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layId, container, false)
        _binding.lifecycleOwner = this
        initUI()
        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        job.cancel()
    }

    abstract fun initUI()
}