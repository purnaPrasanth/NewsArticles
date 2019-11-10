package com.purnaprasanth.baseandroid.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


/**
 * Created by purna on 2019-11-10
 **/

@BindingAdapter(value = ["articleImage"], requireAll = true)
fun loadArticleImage(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView.context).load(imageUrl).into(imageView)
}