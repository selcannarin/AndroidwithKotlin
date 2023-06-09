package com.selcannarin.flagsquizapp

import DatabaseCopyHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.flagsquizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        copyDatabase()

        binding.buttonStart.setOnClickListener {
            startActivity(Intent(this@MainActivity,QuizActivity::class.java))
        }
    }

    fun copyDatabase(){

        val copyHelper = DatabaseCopyHelper(this)

        try{
            copyHelper.createDataBase()
            copyHelper.openDataBase()

        }catch (e:Exception){
            e.printStackTrace()
        }

    }
}