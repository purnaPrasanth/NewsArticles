package com.purnaprasanth.articles.articledetail

import android.net.Uri
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
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
        binding.article = articleDetail
        binding.link.setOnClickListener {
            val tabsIntent = CustomTabsIntent.Builder().apply {
                setShowTitle(true)
            }.build()
            tabsIntent.launchUrl(requireContext(), Uri.parse(articleDetail.articleLink))
        }
    }

    companion object {

        const val BUNDLE_ARTICLE_DETAIL_FRAGMENT = "BUNDLE_ARTICLE_DETAIL_FRAGMENT"

        fun newFragment(articleDetail: ArticleDetail) = ArticleDetailFragment().apply {
            val bundle = Bundle().apply {
                putParcelable(BUNDLE_ARTICLE_DETAIL_FRAGMENT, articleDetail)
            }
        }
    }
}