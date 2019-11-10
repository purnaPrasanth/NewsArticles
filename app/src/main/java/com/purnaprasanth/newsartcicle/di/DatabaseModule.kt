package com.purnaprasanth.newsartcicle.di

import android.content.Context
import android.os.Debug
import androidx.room.Room
import com.purnaprasanth.base.annotation.App
import com.purnaprasanth.newsarticles.data.db.ArticlesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by purna on 2019-11-10
 **/

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@App context: Context): ArticlesDatabase {
        val builder = Room.databaseBuilder(context, ArticlesDatabase::class.java, "articles.db")
            .fallbackToDestructiveMigration()
        if (Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        return builder.build()
    }

    @Provides
    fun provideArticlesDao(db: ArticlesDatabase) = db.articleDao()
}