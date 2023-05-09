package com.selcannarin.flagsquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.flagsquizapp.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonAnswer1.setOnClickListener {
            startActivity(Intent(this@QuizActivity,ResultActivity::class.java))
            finish()
        }


    }
}