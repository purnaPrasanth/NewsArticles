package com.purnaprasanth.articles.articledetail

import android.os.Bundle
import com.purnaprasanth.articles.R
import com.purnaprasanth.articles.databinding.FragmentArticledetailBinding
import com.purnaprasanth.baseandroid.BaseFragment
import com.purnaprasanth.newsarticles.data.model.ArticleDetail

/**
 * Created by purna on 2019-11-05
 **/

class ArticleDetailFragment :
    BaseFragment<FragmentArticledetailBinding>(R.layout.fragment_articledetail) {

    val articleDetail: ArticleDetail by lazy {
        arguments!!.getParcelable<ArticleDetail>(BUNDLE_ARTICLE_DETAIL_FRAGMENT) as ArticleDetail
    }

    override fun initUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        private const val BUNDLE_ARTICLE_DETAIL_FRAGMENT = "BUNDLE_ARTICLE_DETAIL_FRAGMENT"

        fun newFragment(articleDetail: ArticleDetail) = ArticleDetailFragment().apply {
            val bundle = Bundle().apply {
                putParcelable(BUNDLE_ARTICLE_DETAIL_FRAGMENT, articleDetail)
            }
        }
    }
}