package com.selcannarin.recyclercardview1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.selcannarin.recyclercardview1.databinding.CardViewDesignBinding

class RVAdapter(private val mContext:Context,private val countryList:List<Countries>):RecyclerView.Adapter<RVAdapter.CardViewHolder>() {

    inner class CardViewHolder(private val binding: CardViewDesignBinding) : RecyclerView.ViewHolder(binding.root){
        var countryName:TextView = binding.textViewCountry
        var lineCardView:CardView = binding.cardViewLine
        var imagePoint:ImageView = binding.imageViewPoint

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val country = countryList[position]
        holder.countryName.text = country.CountryName

        holder.lineCardView.setOnClickListener{
            Toast.makeText(mContext, "Country: ${country.CountryName}",Toast.LENGTH_SHORT).show()
        }
        holder.imagePoint.setOnClickListener{

            val popup = PopupMenu(mContext,holder.imagePoint)
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener { item->
                when(item.itemId){
                    R.id.Item_delete -> {
                        Toast.makeText(mContext,"Delete: ${country.CountryName}",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.Item_save -> {
                        Toast.makeText(mContext,"Save: ${country.CountryName}",Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}