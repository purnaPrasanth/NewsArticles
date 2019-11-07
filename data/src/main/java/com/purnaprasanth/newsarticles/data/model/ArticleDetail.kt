package com.purnaprasanth.newsarticles.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by purna on 2019-11-04
 **/

@Parcelize
data class ArticleDetail(
    val title: String,
    val coverImage: String,
    val abstract: String,
    val authorName: String,
    val publishData: String,
    val articleLink: String
) : Parcelable