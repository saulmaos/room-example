package com.recodigo.howtouseroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.room.Room

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private val books: ArrayList<BookEntity> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        database = Room.databaseBuilder(
            application, AppDatabase::class.java, AppDatabase.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .build()

        btnBooks.setOnClickListener {
            val books = database.booksDao.getAllBooks()
            tvBooks.text = "" // This will reset the text of TextView
            books.forEach { book ->
                tvBooks.append("${book.id}, ${book.title}, ${book.author}, ${book.pubDate}\n")
            }
            this.books.clear()
            this.books.addAll(books)
        }
    }

    private fun saveBooks() {
        val book1 = BookEntity(title = "Moby Dick", author = "Herman Melville", pubDate = "1851")
        val book2 = BookEntity(title = "Taipi", author = "Herman Melville", pubDate = "1846")
        val book3 =
            BookEntity(title = "Don Quixote", author = "Miguel de Cervantes", pubDate = "1605")
        val book4 =
            BookEntity(title = "El gran Garsby", author = "F. Scott Fitzgerald", pubDate = "1925")
        val book5 = BookEntity(title = "War and Peace", author = "Leo Tolstoy", pubDate = "1869")
        database.booksDao.insert(book1)
        database.booksDao.insert(book2)
        database.booksDao.insert(book3)
        database.booksDao.insert(book4)
        database.booksDao.insert(book5)
    }

    //  This will create the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_insert_all -> saveBooks()
            R.id.action_update -> updateFirstBook()
            R.id.action_delete -> deleteFirstBook()
            R.id.action_delete_all -> deleteAll()
            R.id.action_books_by_author -> getBooksByAuthor()
            R.id.action_all_titles -> getAllTitles()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateFirstBook() {
        if (books.size > 0) {
            books.first().title = "Otro libro"
            database.booksDao.update(books.first())
        }
    }

    private fun deleteFirstBook() {
        if (books.size > 0)
            database.booksDao.delete(books.first())
    }

    // This method is provided by Room
    private fun deleteAll() {
        database.clearAllTables()
    }

    private fun getBooksByAuthor() {
        val books = database.booksDao.getBooksByAuthor("Herman Melville")
        tvBooks.text = ""
        books.forEach { book ->
            tvBooks.append("${book.id}, ${book.title}, ${book.author}, ${book.pubDate}\n")
        }
    }

    private fun getAllTitles() {
        val titles = database.booksDao.getAllTitles()
        tvBooks.text = ""
        titles.forEach { title ->
            tvBooks.append("$title\n")
        }
    }
}