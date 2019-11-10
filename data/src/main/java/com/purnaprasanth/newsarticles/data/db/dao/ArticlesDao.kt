package com.purnaprasanth.newsarticles.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.purnaprasanth.newsarticles.data.db.EntityDao
import com.purnaprasanth.newsarticles.data.model.ArticleDetail
import io.reactivex.Observable

/**
 * Created by purna on 2019-11-10
 **/

@Dao
abstract class ArticlesDao : EntityDao<ArticleDetail> {
    @Query("SELECT * from articles WHERE lower(section) = :section")
    abstract fun observeArticles(section: String): Observable<List<ArticleDetail>>
}