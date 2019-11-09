package com.purnaprasanth.baseandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.purnaprasanth.base.AppRxSchedulers
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by purna on 2019-11-09
 **/

abstract class BaseFragment<BINDING : ViewDataBinding>(
    @LayoutRes val layId: Int
) : DaggerFragment() {

    private lateinit var _binding: BINDING

    protected val binding: BINDING
        get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appRxSchedulers: AppRxSchedulers

    protected val viewModelProvider: ViewModelProvider by lazy {
        ViewModelProviders.of(this, viewModelFactory)
    }

    private val compositeDisposable = CompositeDisposable()

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

    override fun onDestroyView() {
        compositeDisposable.dispose()
        super.onDestroyView()
    }

    abstract fun initUI()
}