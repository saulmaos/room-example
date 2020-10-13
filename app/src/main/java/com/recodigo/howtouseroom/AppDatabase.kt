package com.recodigo.howtouseroom

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by SAUL on 03/10/2020.
 */
@Database(
    entities = [BookEntity::class, AuthorEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract val booksDao: BooksDao
    abstract val authorsDao: AuthorsDao

    companion object {
        const val DATABASE_NAME = "db-recodigo"
    }
}