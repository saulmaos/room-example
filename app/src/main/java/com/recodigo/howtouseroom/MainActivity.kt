package com.recodigo.howtouseroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        database = Room.databaseBuilder(
            application, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .allowMainThreadQueries()
            .build()
//        saveBooks()

        btnBooks.setOnClickListener {
            val books = database.booksDao.getAllBooks()
            books.forEach { book ->
                tvBooks.append("${book.id}, ${book.title}, ${book.author}, ${book.pubDate}\n")
            }
        }
    }

    private fun saveBooks() {
        val book1 = BookEntity(title = "Mobby Dick", author = "Herman Melville", pubDate = "1851")
        val book2 = BookEntity(title = "Mobby Dick 2", author = "Herman Melville", pubDate = "1851")
        val book3 = BookEntity(title = "Mobby Dick 3", author = "Herman Melville", pubDate = "1851")
        val book4 = BookEntity(title = "Mobby Dick 4", author = "Herman Melville", pubDate = "1851")
        val book5 = BookEntity(title = "Mobby Dick 5", author = "Herman Melville", pubDate = "1851")
        database.booksDao.insert(book1)
        database.booksDao.insert(book2)
        database.booksDao.insert(book3)
        database.booksDao.insert(book4)
        database.booksDao.insert(book5)
    }
}