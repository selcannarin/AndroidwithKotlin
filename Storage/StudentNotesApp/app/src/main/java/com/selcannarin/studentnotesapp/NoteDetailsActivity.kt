package com.selcannarin.studentnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.selcannarin.studentnotesapp.databinding.ActivityNoteDetailsBinding
import com.selcannarin.studentnotesapp.databinding.ActivitySaveNoteBinding

class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarDetails.title = "Note Details"
        setSupportActionBar(binding.toolbarDetails)

        val note = intent.getSerializableExtra("object") as Notes
        binding.editTextStudent.setText(note.student_name)
        binding.editTextNote1.setText(note.note1)
        binding.editTextNote2.setText(note.note2)
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
                        startActivity(Intent(this@NoteDetailsActivity,MainActivity::class.java))
                        finish()
                    }
                return true
            }
            R.id.action_edit -> {
                startActivity(Intent(this@NoteDetailsActivity,MainActivity::class.java))
                finish()
                return true
            }
            else -> return false
        }

        return super.onOptionsItemSelected(item)
    }
}