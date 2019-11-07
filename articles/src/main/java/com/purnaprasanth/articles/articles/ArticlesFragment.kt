package com.purnaprasanth.articles.articles

import com.purnaprasanth.articles.R
import com.purnaprasanth.articles.databinding.FragmentArticlesBinding
import com.purnaprasanth.base.mvi.MviView
import com.purnaprasanth.baseandroid.BaseFragment
import io.reactivex.Observable


/**
 * Created by purna on 2019-11-05
 **/

class ArticlesFragment : BaseFragment<FragmentArticlesBinding>(R.layout.fragment_articles), MviView<ArticlesIntent, ArticlesViewState> {

    override fun initUI() {

    }

    override fun intents(): Observable<ArticlesIntent> {
        TODO()
    }

    override fun render(state: ArticlesViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}