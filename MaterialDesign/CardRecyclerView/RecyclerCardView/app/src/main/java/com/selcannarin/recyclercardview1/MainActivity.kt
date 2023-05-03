package com.selcannarin.recyclercardview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.selcannarin.recyclercardview1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryList: ArrayList<Countries>
    private lateinit var adapter: RVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = GridLayoutManager(this, 1)

        val c1 = Countries(1, "Turkey")
        val c2 = Countries(2, "Japan")
        val c3 = Countries(3, "Korea")
        val c4 = Countries(4, "Russia")
        val c5 = Countries(5,"America")
        val c6 = Countries(6,"England")
        val c7 = Countries(7,"Poland")
        val c8 = Countries(8,"Austria")
        val c9 = Countries(9,"France")

        countryList = ArrayList<Countries>()
        countryList.add(c1)
        countryList.add(c2)
        countryList.add(c3)
        countryList.add(c4)
        countryList.add(c5)
        countryList.add(c6)
        countryList.add(c7)
        countryList.add(c8)
        countryList.add(c9)

        adapter = RVAdapter(this, countryList)
        binding.recyclerview.adapter = adapter


    }
}
