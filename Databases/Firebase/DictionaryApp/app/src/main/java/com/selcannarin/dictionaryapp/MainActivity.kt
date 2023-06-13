package com.selcannarin.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.selcannarin.dictionaryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: WordsAdapter

    private lateinit var refWords : DatabaseReference

    private lateinit var wordsList : ArrayList<Words>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val db = FirebaseDatabase.getInstance()
        refWords = db.getReference("words")

        wordsList = ArrayList()

        adapter = WordsAdapter(this, wordsList)
        binding.recyclerView.adapter = adapter

        allWords()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        val item = menu?.findItem(R.id.actionSearch)
        val searchView = item?.actionView as SearchView
       // searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    fun allWords () {

        refWords.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                wordsList.clear()

                for (w in snapshot.children){
                    val word = w.getValue(Words::class.java)

                    if(word != null) {
                        word.word_id = w.key
                        wordsList.add(word)
                    }

                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }


}