package com.purnaprasanth.articles.articles

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.purnaprasanth.articles.R
import com.purnaprasanth.articles.databinding.FragmentArticlesBinding
import com.purnaprasanth.base.mvi.MviView
import com.purnaprasanth.baseandroid.BaseMviFragment
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by purna on 2019-11-05
 **/

class ArticlesFragment :
    BaseMviFragment<FragmentArticlesBinding, ArticlesIntent, ArticlesViewState, ArticlesViewModel>(
        R.layout.fragment_articles,
        ArticlesViewModel::class.java
    ), MviView<ArticlesIntent, ArticlesViewState> {

    private val refreshArticlesIntent =
        PublishSubject.create<ArticlesIntent.RefreshArticlesIntent>()
    private val changeFilterIntents =
        PublishSubject.create<ArticlesIntent.ChangeFilterIntent>().apply {
            startWith(ArticlesIntent.ChangeFilterIntent(ArticleFiler.Science))
        }

    @Inject
    lateinit var adapter: ArticlesRvAdapter

    private val spinnerAdapter by lazy {
        ArrayAdapter(
            requireContext(),
            R.layout.item_filter_spinner,
            arrayOf(
                ArticleFiler.Science,
                ArticleFiler.World,
                ArticleFiler.Business,
                ArticleFiler.Movies,
                ArticleFiler.Technology,
                ArticleFiler.Travel
            )
        )
    }

    override fun initUI() {
        binding.articlesList.layoutManager = LinearLayoutManager(requireContext())
        binding.articlesList.adapter = adapter
        binding.filterType.adapter = spinnerAdapter
        binding.filterType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                changeFilterIntents.onNext(ArticlesIntent.ChangeFilterIntent(ArticleFiler.Science))
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                changeFilterIntents.onNext(
                    ArticlesIntent.ChangeFilterIntent(
                        parent!!.getItemAtPosition(position) as ArticleFiler
                    )
                )
            }
        }
        binding.swipeToRefreshLay.setOnRefreshListener {
            refreshArticlesIntent.onNext(
                ArticlesIntent.RefreshArticlesIntent(binding.filterType.selectedItem as ArticleFiler)
            )
        }
    }

    override fun intents(): Observable<ArticlesIntent> {
        return Observable.merge(
            refreshArticlesIntent,
            changeFilterIntents
        )
    }

    override fun render(state: ArticlesViewState) {
        binding.swipeToRefreshLay.isRefreshing = state.isLoading

        when {
            state.error != null -> // Handle Error
                return
            state.articles.isEmpty() -> { // Empty View
                adapter.submitList(state.articles)
                return
            }
            else -> {
                adapter.submitList(state.articles)
                return
            }
        }
    }

}