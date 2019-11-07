package com.purnaprasanth.baseandroid

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.purnaprasanth.base.AppRxSchedulers
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by viking_93 on 2019-11-03
 **/

/**
 * Base Class for activities across the app that heavily uses @see <a href="https://developer.android.com/topic/libraries/data-binding">Data Binding</a>
 *
 * @param BINDING type of view binding that this [DaggerAppCompatActivity] uses
 * @param layoutId the layout id for [setContentView]
 *
 * This also implements [CoroutineScope], hence acts as a parent for all the coRoutines started in this activity scope or Lifecycle
 * @property parentJob parent job for the coRoutines started in this scope
 * @property binding Binding class made available for child classes for introducing effects
 */

abstract class BaseActivity<BINDING : ViewDataBinding>(@LayoutRes val layoutId: Int) :
    DaggerAppCompatActivity() {
    protected lateinit var binding: BINDING

    protected abstract val TAG: String

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var appRxSchedulers: AppRxSchedulers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        AndroidInjection.inject(this)
        initUI()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    abstract fun initUI()
}