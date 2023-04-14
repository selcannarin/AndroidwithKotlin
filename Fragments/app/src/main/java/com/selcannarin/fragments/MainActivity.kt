package com.selcannarin.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        ft.add(R.id.first_fragment,FirstFragment())
        ft.add(R.id.second_fragment,SecondFragment())

        ft.commit()
    }
}