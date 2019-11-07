package com.purnaprasanth.newsartcicle.app

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.purnaprasanth.baseandroid.BaseActivity
import com.purnaprasanth.newsartcicle.R
import com.purnaprasanth.newsartcicle.databinding.ActivityMainBinding

class AppActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var navController: NavController
    override val TAG: String
        get() = "AppActivity"

    override fun initUI() {
        navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.navigate_to_article_detail)
    }
}
