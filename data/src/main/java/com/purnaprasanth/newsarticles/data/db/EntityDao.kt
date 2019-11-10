package com.purnaprasanth.newsarticles.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 * Created by purna on 2019-11-10
 **/

interface EntityDao<in E : BaseEntity> {

    @Insert
    fun insert(entity: E): Long

    @Insert
    fun insertAll(vararg entities: E)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(entities: List<E>)

    @Update
    fun update(entity: E)

    @Delete
    fun delete(entity: E): Int
}