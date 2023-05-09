package com.selcannarin.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.datastore.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private lateinit var appPreferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appPreferences = AppPreferences(this)

        GlobalScope.launch {
            appPreferences.incrementLoginCount()
            binding.textViewLoginCounter.text = "Number of Login : ${appPreferences.getLoginCount()}"

        }




    }
}