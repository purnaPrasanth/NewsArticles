package com.purnaprasanth.newsartcicle.app

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.purnaprasanth.articles.navigation.IArticlesNavigation
import com.purnaprasanth.baseandroid.BaseActivity
import com.purnaprasanth.newsartcicle.R
import com.purnaprasanth.newsartcicle.databinding.ActivityAppBinding
import com.purnaprasanth.newsarticles.data.model.ArticleDetail

class AppActivity : BaseActivity<ActivityAppBinding>(R.layout.activity_app), IArticlesNavigation {

    private lateinit var navController: NavController

    override val TAG: String
        get() = "AppActivity"

    override fun viewArticleDetails(articleDetail: ArticleDetail) {
        /*val bundle = Bundle().apply {
            putParcelable(ArticleDetailFragment.BUNDLE_ARTICLE_DETAIL_FRAGMENT, articleDetail)
        }
        navController.navigate(R.id.navigate_to_article_detail, bundle)*/
    }

    override fun initUI() {
        navController = findNavController(R.id.nav_host_fragment)
    }
}
