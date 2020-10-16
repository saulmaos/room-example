package com.recodigo.howtouseroom

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Created by SAUL on 16/10/2020.
 */
object Migrations {
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // CREATE A TEMPORAL TABLE
            database.execSQL(
                "CREATE TABLE books_temporal (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        "title TEXT NOT NULL, " +
                        "author TEXT NOT NULL, " +
                        "pub_date INTEGER NOT NULL, " +
                        "FOREIGN KEY(author) REFERENCES authors(name) ON UPDATE NO ACTION ON DELETE NO ACTION" +
                        ")"
            )
            // COPY THE DATA FROM books TO books_temporal
            database.execSQL(
                "INSERT INTO books_temporal " +
                        "(title, author, pub_date) " +
                        "SELECT title, author, pub_dates FROM books"
            )
            // DELETE OLD DATABASE
            database.execSQL("DROP TABLE books")
            // RENAME THE TEMPORAL DATABASE
            database.execSQL("ALTER TABLE books_temporal RENAME TO books")
        }

    }
}