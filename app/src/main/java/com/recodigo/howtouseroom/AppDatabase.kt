package com.recodigo.howtouseroom

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by SAUL on 03/10/2020.
 */
@Database(entities = [BookEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract val booksDao: BooksDao

    companion object {
        const val DATABASE_NAME = "db-recodigo"
    }
}