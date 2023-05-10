package com.selcannarin.dictionaryapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class WordsDbHelper (context: Context)
    : SQLiteOpenHelper(context, "dictionary.sqlite", null, 1){

    object WordsReaderContract {
        // Table contents are grouped together in an anonymous object.
        object FeedEntry : BaseColumns {
            const val TABLE_NAME = "Words"
            const val COLUMN_NAME_TURKISH = "turkish"
            const val COLUMN_NAME_ENGLISH = "english"
        }
    }

    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE IF NOT EXISTS ${WordsReaderContract.FeedEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${WordsReaderContract.FeedEntry.COLUMN_NAME_TURKISH} TEXT," +
                "${WordsReaderContract.FeedEntry.COLUMN_NAME_ENGLISH} TEXT)"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${WordsReaderContract.FeedEntry.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }




}

