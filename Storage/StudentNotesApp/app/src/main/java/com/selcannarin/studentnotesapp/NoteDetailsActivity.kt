package com.selcannarin.studentnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.selcannarin.studentnotesapp.databinding.ActivityNoteDetailsBinding
import com.selcannarin.studentnotesapp.databinding.ActivitySaveNoteBinding

class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteDetailsBinding
    private lateinit var dbHelper: NotesDbHelper
    private lateinit var note : Notes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarDetails.title = "Note Details"
        setSupportActionBar(binding.toolbarDetails)

        dbHelper = NotesDbHelper(this)
        note = intent.getSerializableExtra("object") as Notes
        binding.editTextStudent.setText(note.student_name)
        binding.editTextNote1.setText((note.note1).toString())
        binding.editTextNote2.setText((note.note2).toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_delete -> {
                Snackbar.make(binding.toolbarDetails,"Do you wanna delete?",Snackbar.LENGTH_SHORT)
                    .setAction("YES"){
                        Notesdao().deleteNote(dbHelper,note.student_id)
                        startActivity(Intent(this@NoteDetailsActivity,MainActivity::class.java))
                        finish()
                    }.show()
                return true
            }
            R.id.action_edit -> {
                val student_name = binding.editTextStudent.text.toString().trim()
                val note1 = binding.editTextNote1.text.toString().trim()
                val note2 = binding.editTextNote2.text.toString().trim()

                if(TextUtils.isEmpty(student_name)){
                    Snackbar.make(binding.toolbarDetails,"Enter the student's name.",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if(TextUtils.isEmpty(note1)){
                    Snackbar.make(binding.toolbarDetails,"Enter the first note.",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if(TextUtils.isEmpty(note2)){
                    Snackbar.make(binding.toolbarDetails,"Enter the second note.",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                Notesdao().editNote(dbHelper,note.student_id,student_name,note1.toInt(),note2.toInt())

                startActivity(Intent(this@NoteDetailsActivity,MainActivity::class.java))
                finish()
                return true
            }
            else -> return false
        }

    }
}