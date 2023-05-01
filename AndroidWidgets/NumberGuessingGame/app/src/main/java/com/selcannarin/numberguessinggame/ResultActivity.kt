package com.selcannarin.numberguessinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.numberguessinggame.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val result = intent.getBooleanExtra("result",false)

        if(result){
            binding.imageViewResult.setImageResource(R.drawable.happy_image)
            binding.textViewResult.text = "YOU WIN THE GAME"
        }else{
            binding.imageViewResult.setImageResource(R.drawable.sad_image)
            binding.textViewResult.text = "YOU LOSE THE GAME"
        }

        binding.buttonPlayAgain.setOnClickListener {
            val intent = Intent(this@ResultActivity,GuessActivity::class.java)
            finish()
            startActivity(intent)
        }

    }
}