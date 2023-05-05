package com.selcannarin.sharedprefences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.sharedprefences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPrefs = getSharedPreferences("Login Counter", Context.MODE_PRIVATE)

        var counter = sharedPrefs.getInt("counter",0)
        val editor = sharedPrefs.edit()

        editor.putInt("counter",++counter)
        editor.commit()
        binding.textViewLoginCounter.text = "Login Counter: $counter"


    }
}