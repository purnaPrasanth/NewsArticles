package com.purnaprasanth.articles.articles

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.purnaprasanth.articles.R
import com.purnaprasanth.articles.databinding.ItemArticlesBinding
import com.purnaprasanth.baseandroid.SingleTypeBaseRvAdapter
import com.purnaprasanth.newsarticles.data.model.ArticleDetail
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by purna on 2019-11-09
 **/

class ArticlesRvAdapter @Inject constructor(context: Context, diffCallback: ArticlesDiffCallback) :
    SingleTypeBaseRvAdapter<ItemArticlesBinding, ArticleDetail>(
        context,
        R.layout.item_articles,
        diffCallback
    ) {
    private val TAG = "ArticlesRvAdapter"

    override fun onBindViewHolder(binding: ItemArticlesBinding, position: Int) {
        binding.article = getItem(position)
    }
}

@Singleton
class ArticlesDiffCallback @Inject constructor() : DiffUtil.ItemCallback<ArticleDetail>() {
    override fun areItemsTheSame(oldItem: ArticleDetail, newItem: ArticleDetail) =
        oldItem.articleLink == newItem.articleLink

    override fun areContentsTheSame(oldItem: ArticleDetail, newItem: ArticleDetail) =
        oldItem == newItem

}