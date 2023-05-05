package com.selcannarin.sharedprefsloginapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selcannarin.sharedprefsloginapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //writing the information
        val sp = getSharedPreferences("LoginInfo", Context.MODE_PRIVATE)

        val un = sp.getString("username","no username")
        val pw = sp.getString("password","no password")

        binding.textViewInfo.text = "Username : $un Password : $pw"

        //after sign out, we should delete infos.
        binding.buttonSignOut.setOnClickListener{

            val editor = sp.edit()
            editor.remove("username")
            editor.remove("password")
            editor.commit()

            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finish()
        }
    }
}