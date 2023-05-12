package com.selcannarin.studentnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.selcannarin.studentnotesapp.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var notesList: ArrayList<Notes>
    private lateinit var adapter: NotesAdapter
    private lateinit var dbHelper: NotesDbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Student Notes App"
        setSupportActionBar(binding.toolbar)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        dbHelper = NotesDbHelper(this)
       // Notesdao().addNote(dbHelper, "Selcan Narin", 12,78)

        notesList = Notesdao().allNotes(dbHelper)
        //notesList = ArrayList<Notes>()
        //val n1 = Notes(2,"selcna",23,323)
        //notesList.add(n1)

        adapter = NotesAdapter(this,notesList)
        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener{
            startActivity(Intent(this@MainActivity,SaveNoteActivity::class.java))
        }


    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        super.onBackPressed()
    }

}