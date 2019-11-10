package com.purnaprasanth.newsarticles.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.purnaprasanth.newsarticles.data.db.dao.ArticlesDao
import com.purnaprasanth.newsarticles.data.model.ArticleDetail

/**
 * Created by purna on 2019-11-10
 **/

@Database(
    entities = [
        ArticleDetail::class
    ], version = 1, exportSchema = false
)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticlesDao

    companion object {
        fun getDatabase(context: Context) {

        }
    }
}