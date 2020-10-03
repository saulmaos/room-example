package com.recodigo.howtouseroom

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by SAUL on 03/10/2020.
 */
@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "title")
    @NonNull
    var title: String,

    @ColumnInfo(name = "author")
    @NonNull
    var author: String,

    @ColumnInfo(name = "pub_date")
    @NonNull
    var pubDate: String
) {

}