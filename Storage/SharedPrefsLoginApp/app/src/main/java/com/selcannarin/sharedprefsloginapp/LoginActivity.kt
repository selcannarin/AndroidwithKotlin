package com.selcannarin.sharedprefsloginapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.selcannarin.sharedprefsloginapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //First check if there is a user who has already logged into the system
        //Information is retrieved from sharedprefences and checked, if any, it goes directly to MainActivity.
        val sp = getSharedPreferences("LoginInfo", Context.MODE_PRIVATE)
        val loggedusername = sp.getString("username","No user name")
        val loggedpassword = sp.getString("password","No password")

        if((loggedusername=="admin")&&(loggedpassword=="123")){
            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            finish()
        }

        // if there is no previous login, it enters the information and logs in.
        binding.buttonSignIn.setOnClickListener{

            val un = binding.editTextName.text.toString()
            val pw = binding.editTextPassword.text.toString()

            if( un == "admin" && pw == "123"){

                val editor = sp.edit()
                editor.putString("username",un)
                editor.putString("password",pw)
                editor.commit()

                startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                finish()

            }else{
                Toast.makeText(applicationContext,"Wrong Login",Toast.LENGTH_SHORT).show()
            }



        }
    }
}