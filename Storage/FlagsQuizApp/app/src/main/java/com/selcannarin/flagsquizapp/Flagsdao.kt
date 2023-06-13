package com.selcannarin.flagsquizapp

import android.annotation.SuppressLint

class Flagsdao {

    fun random5Flags(db:DatabaseHelper) : ArrayList<Flags> {
        val flagsList = ArrayList<Flags>()
        val db = db.readableDatabase
        val c = db.rawQuery("SELECT * FROM Flags ORDER BY RANDOM() LIMIT 5",null)

        while(c.moveToNext()){
            val flag = Flags(c.getInt(c.getColumnIndexOrThrow("flag_id"))
                ,c.getString(c.getColumnIndexOrThrow("flag_name"))
                ,c.getString(c.getColumnIndexOrThrow("flag_image")))
            flagsList.add(flag)
        }

        return flagsList
    }

    fun random3WrongAnswer(db:DatabaseHelper,flag_id:Int) : ArrayList<Flags> {
        val flagsList = ArrayList<Flags>()
        val db = db.readableDatabase
        val c = db.rawQuery("SELECT * FROM Flags WHERE flag != $flag_id ORDER BY RANDOM() LIMIT 3",null)

        while(c.moveToNext()){
            val flag = Flags(c.getInt(c.getColumnIndexOrThrow("flag_id"))
                ,c.getString(c.getColumnIndexOrThrow("flag_name"))
                ,c.getString(c.getColumnIndexOrThrow("flag_image")))
            flagsList.add(flag)
        }

        return flagsList
    }
}