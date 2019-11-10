package com.purnaprasanth.newsarticles.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.purnaprasanth.newsarticles.data.db.BaseEntity
import kotlinx.android.parcel.Parcelize

/**
 * Created by purna on 2019-11-04
 **/

@Entity(
    tableName = "articles",
    indices = [Index(value = ["article_link", "section"], unique = true)]
)
@Parcelize
data class ArticleDetail(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override var id: Long,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "cover_image") var coverImage: String,
    @ColumnInfo(name = "abstract") var abstract: String,
    @ColumnInfo(name = "author_name") var authorName: String,
    @ColumnInfo(name = "publish_data") var publishData: String,
    @ColumnInfo(name = "article_link") var articleLink: String,
    @ColumnInfo(name = "section") var section: String
) : Parcelable, BaseEntity {
    constructor() : this(0, "", "", "", "", "", "", "")
}
