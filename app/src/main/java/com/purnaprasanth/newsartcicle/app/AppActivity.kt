package com.purnaprasanth.newsartcicle.app

import android.util.Log
import androidx.navigation.NavController
import com.purnaprasanth.baseandroid.BaseActivity
import com.purnaprasanth.newsartcicle.R
import com.purnaprasanth.newsartcicle.databinding.ActivityAppBinding
import dagger.android.HasAndroidInjector

class AppActivity : BaseActivity<ActivityAppBinding>(R.layout.activity_app) {

    private lateinit var navController: NavController

    override val TAG: String
        get() = "AppActivity"

    override fun initUI() {
        Log.d(TAG, "Hello")
//        navController = findNavController(R.id.nav_host_fragment)
//        navController.navigate(R.id.navigate_to_article_detail)
    }
}
