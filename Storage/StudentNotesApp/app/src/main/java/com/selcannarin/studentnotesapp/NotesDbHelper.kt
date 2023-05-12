package com.selcannarin.studentnotesapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class NotesDbHelper (context:Context) : SQLiteOpenHelper (context, "notes.sqlite", null, 1){


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Notes(student_id INTEGER PRIMARY KEY AUTOINCREMENT ,student_name TEXT,note1 INTEGER,note2 INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db?.execSQL("DROP TABLE IF EXISTS Notes")
        onCreate(db)
    }


}