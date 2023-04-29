package com.selcannarin.numberguessinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.selcannarin.numberguessinggame.databinding.ActivityGuessBinding
import kotlin.random.Random

class GuessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuessBinding
    private var randomNumber = 0
    private var counter = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuessBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        randomNumber = Random.nextInt(101)
        Log.e("Random Number",randomNumber.toString())

        binding.buttonGuess.setOnClickListener {

            counter--
            val guess = binding.editTextInputNumber.text.toString().toInt()

            if(guess==randomNumber){
                val intent = Intent(this@GuessActivity,ResultActivity::class.java)
                intent.putExtra("result",true)
                finish() //have to delete it from backstack because we can't go back again
                startActivity(intent)

                return@setOnClickListener //The following codes will not work.
            }
            if(guess>randomNumber){
                binding.textViewHelp.text = "Decrease"
                binding.textViewRemainingPlay.text = "Remaining Play: $counter"
            }
            if(guess<randomNumber){
                binding.textViewHelp.text = "Increase"
                binding.textViewRemainingPlay.text = "Remaining Play: $counter"
            }
            if(counter==0){
                val intent = Intent(this@GuessActivity,ResultActivity::class.java)
                intent.putExtra("sonuc",false)
                finish() //should delete from backstack because we can't go back it again
                startActivity(intent)
            }
            binding.editTextInputNumber.setText("")
        }

    }
}