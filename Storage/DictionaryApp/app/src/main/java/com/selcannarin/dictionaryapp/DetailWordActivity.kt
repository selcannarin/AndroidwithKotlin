package com.selcannarin.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.dictionaryapp.databinding.ActivityDetailWordBinding
import com.selcannarin.dictionaryapp.databinding.ActivityMainBinding

class DetailWordActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val words = intent.getSerializableExtra("object") as Words

        binding.textViewEnglish.text = words.english
        binding.textViewTurkish.text = words.turkish
    }
}