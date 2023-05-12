package com.selcannarin.studentnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import com.selcannarin.studentnotesapp.databinding.ActivitySaveNoteBinding

class SaveNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySaveNoteBinding
    private lateinit var dbHelper: NotesDbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarSaveNote.title ="Notes Registration"
        setSupportActionBar(binding.toolbarSaveNote)

        dbHelper = NotesDbHelper(this)

        binding.buttonSave.setOnClickListener {

            val student_name = binding.editTextStudentName.text.toString().trim()
            val note1 = binding.editTextNote1.text.toString().trim()
            val note2 = binding.editTextNote2.text.toString().trim()

            if(TextUtils.isEmpty(student_name)){
                Snackbar.make(binding.toolbarSaveNote,"Enter the student's name.",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(note1)){
                Snackbar.make(binding.toolbarSaveNote,"Enter the first note.",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(note2)){
            Snackbar.make(binding.toolbarSaveNote,"Enter the second note.",Snackbar.LENGTH_SHORT).show()
            return@setOnClickListener
        }
            Notesdao().addNote(dbHelper, student_name, note1.toInt(),note2.toInt())

            startActivity(Intent(this@SaveNoteActivity,MainActivity::class.java))
            finish()
        }
    }
}