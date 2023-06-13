package com.selcannarin.dictionaryapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.selcannarin.dictionaryapp.databinding.CardViewWordsBinding

class WordsAdapter (private val context: Context, private val wordsList: ArrayList<Words>)
    :RecyclerView.Adapter<WordsAdapter.CardViewHolder>(){

    private lateinit var binding: CardViewWordsBinding

    inner class CardViewHolder (private val binding:CardViewWordsBinding) : RecyclerView.ViewHolder(binding.root){

        var textViewTurkishWord : TextView = binding.textViewTurkishWord
        var textViewEnglishWord : TextView = binding.textViewEnglishWord
        var cardViewWords  = binding.cardViewWords
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardViewWordsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val word =wordsList[position]
        holder.textViewEnglishWord.text = word.english
        holder.textViewTurkishWord.text = word.turkish

        holder.cardViewWords.setOnClickListener{
            val intent = Intent(context,DetailWordActivity::class.java)
            intent.putExtra("object",word)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return wordsList.size
    }

}