package com.selcannarin.bookstorerv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.selcannarin.bookstorerv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var booksList: ArrayList<Books>
    private lateinit var adapter: BooksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = GridLayoutManager(this, 2)

        val book1 = Books(1,"Fahrenheit 451",15.5,"fahrenheit")
        val book2 = Books(2,"Jane Eyre",12.45,"janeeyre")
        val book3 = Books(3,"Lucky Girl",13.55,"luckygirl")
        val book4 = Books(5,"The Book Thief",18.95,"thebookthief")
        val book5 = Books(6,"The Great Gatsby",15.45,"thegreatgatsby")
        val book6 = Books(7,"To Kill A Mockingbird",21.80,"tokillamockingbird")

        booksList = ArrayList<Books>()
        booksList.add(book1)
        booksList.add(book2)
        booksList.add(book3)
        booksList.add(book4)
        booksList.add(book5)
        booksList.add(book6)

        adapter = BooksAdapter(this, booksList)
        binding.rv.adapter = adapter

    }
}