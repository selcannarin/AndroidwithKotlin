package com.selcannarin.studentnotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.studentnotesapp.databinding.ActivityNoteDetailsBinding
import com.selcannarin.studentnotesapp.databinding.ActivitySaveNoteBinding

class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarDetails.title = "Note Details"
    }
}