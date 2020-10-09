package com.recodigo.howtouseroom

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by SAUL on 09/10/2020.
 */
@Entity(tableName = "authors")
data class AuthorEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "year_of_birth")
    @NonNull
    var yearOfBirth: Int,

    @ColumnInfo(name = "number_of_books")
    @NonNull
    var numberOfBooks: Int
)