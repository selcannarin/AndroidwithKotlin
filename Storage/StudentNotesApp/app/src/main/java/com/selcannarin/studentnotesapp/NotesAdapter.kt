package com.selcannarin.studentnotesapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.selcannarin.studentnotesapp.databinding.CardViewNotesBinding

class NotesAdapter (private val context: Context, private val notesList: ArrayList<Notes>)
    :RecyclerView.Adapter<NotesAdapter.CardViewHolder>(){

    private lateinit var binding: CardViewNotesBinding

    inner class CardViewHolder(private val binding:CardViewNotesBinding) : RecyclerView.ViewHolder(binding.root){

        var cardViewNotes:CardView = binding.cardViewNotes
        var textViewStudent:TextView = binding.textViewStudent
        var textViewNote1:TextView = binding.textViewNote1
        var textViewNote2:TextView = binding.textViewNote2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardViewNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val note = notesList[position]
        holder.textViewStudent.text = note.student_name
        holder.textViewNote1.text = (note.note1).toString()
        holder.textViewNote2.text = (note.note2).toString()

        holder.cardViewNotes.setOnClickListener{
            val intent = Intent(context,NoteDetailsActivity::class.java)
            intent.putExtra("object",note)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}