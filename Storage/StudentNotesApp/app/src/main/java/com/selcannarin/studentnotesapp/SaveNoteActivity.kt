package com.selcannarin.studentnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.studentnotesapp.databinding.ActivitySaveNoteBinding

class SaveNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySaveNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarSaveNote.title ="Notes Registration"
        setSupportActionBar(binding.toolbarSaveNote)

        binding.buttonSave.setOnClickListener {
            startActivity(Intent(this@SaveNoteActivity,MainActivity::class.java))
            finish()
        }
    }
}