package com.selcannarin.studentnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.selcannarin.studentnotesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var notesList: ArrayList<Notes>
    private lateinit var adapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Student Notes App"
        setSupportActionBar(binding.toolbar)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        notesList = ArrayList<Notes>()

        adapter = NotesAdapter(this,notesList)
        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener{
            startActivity(Intent(this@MainActivity,SaveNoteActivity::class.java))
        }
    }
}