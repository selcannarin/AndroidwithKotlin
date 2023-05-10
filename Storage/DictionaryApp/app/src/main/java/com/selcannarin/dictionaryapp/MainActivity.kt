package com.selcannarin.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.selcannarin.dictionaryapp.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener {

    lateinit var binding : ActivityMainBinding
    lateinit var wordList : ArrayList<Words>
    lateinit var adapter : WordsAdapter
    lateinit var db : WordsDbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        copyDatabase()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        db = WordsDbHelper(this)
        wordList = Wordsdao().getAllWords(db)

        adapter = WordsAdapter(this,wordList)

        binding.recyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        val item = menu?.findItem(R.id.actionSearch)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        searching(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        searching(newText)
        return true
    }

    fun copyDatabase(){
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun searching(searchedWord:String){
        wordList = Wordsdao().getSearchedWord(db,searchedWord)

        adapter = WordsAdapter(this,wordList)

        binding.recyclerView.adapter = adapter
    }
}
