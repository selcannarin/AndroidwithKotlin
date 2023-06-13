package com.selcannarin.flagsquizapp

import android.content.Intent
import android.os.Binder
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

        val rightCounter = intent.getIntExtra("rightCounter",0)

        binding.textViewResult.text = "$rightCounter TRUE ${5-rightCounter} FALSE"

        binding.textViewSuccessRate.text = "% ${(rightCounter*100)/5} Success"

        binding.buttonPlayAgain.setOnClickListener {
            startActivity(Intent(this@ResultActivity,QuizActivity::class.java))
            finish()
        }
    }
}