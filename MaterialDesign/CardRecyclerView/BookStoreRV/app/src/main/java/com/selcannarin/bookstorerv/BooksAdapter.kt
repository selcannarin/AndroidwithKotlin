package com.selcannarin.bookstorerv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.selcannarin.bookstorerv.databinding.CardViewBookBinding

class BooksAdapter (private val mContext: Context, private val booksList:List<Books>)
    : RecyclerView.Adapter<BooksAdapter.CardViewHolder>(){

    inner class CardViewHolder(private val binding:CardViewBookBinding) : RecyclerView.ViewHolder(binding.root){

        var title:TextView = binding.textViewTitle
        var image:ImageView = binding.imageViewBook
        var price:TextView = binding.textViewPrice
        var addToCart:Button = binding.buttonAddCart

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardViewBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val book = booksList[position]
        holder.title.text = book.bookTitle
        holder.price.text = "${book.bookPrice} $"
        holder.image.setImageResource(mContext.resources.getIdentifier(book.bookImageName,"drawable",mContext.packageName))
        holder.addToCart.setOnClickListener{
            Toast.makeText(mContext,"${book.bookTitle} added to cart.",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }

}