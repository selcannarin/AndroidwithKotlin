package com.selcannarin.flagsquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.flagsquizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonPlayAgain.setOnClickListener {
            startActivity(Intent(this@ResultActivity,QuizActivity::class.java))
            finish()
        }
    }
}