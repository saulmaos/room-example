package com.recodigo.howtouseroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by SAUL on 03/10/2020.
 */
@Dao
interface BooksDao {

    @Insert
    fun insert(book: BookEntity)

    @Query("SELECT * FROM books")
    fun getAllBooks(): List<BookEntity>
}