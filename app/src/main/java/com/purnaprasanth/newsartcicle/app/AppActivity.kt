package com.purnaprasanth.newsartcicle.app

import androidx.navigation.NavController
import com.purnaprasanth.baseandroid.BaseActivity
import com.purnaprasanth.newsartcicle.R
import com.purnaprasanth.newsartcicle.databinding.ActivityAppBinding

class AppActivity : BaseActivity<ActivityAppBinding>(R.layout.activity_app) {

    private lateinit var navController: NavController
    override val TAG: String
        get() = "AppActivity"

    override fun initUI() {
//        navController = findNavController(R.id.nav_host_fragment)
//        navController.navigate(R.id.navigate_to_article_detail)
    }
}
