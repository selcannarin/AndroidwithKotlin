package com.selcannarin.flagquizapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DatabaseHelper (context: Context)
    : SQLiteOpenHelper(context,"flagsquiz.sqlite",null,1) {

    object FlagsReaderContract {
        // Table contents are grouped together in an anonymous object.
        object FeedEntry : BaseColumns {
            const val TABLE_NAME = "Flags"
            const val COLUMN_NAME_NAME = "flag_name"
            const val COLUMN_NAME_IMAGE = "flag_image"
        }
    }

    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE IF NOT EXISTS ${FlagsReaderContract.FeedEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${FlagsReaderContract.FeedEntry.COLUMN_NAME_NAME} TEXT," +
                "${FlagsReaderContract.FeedEntry.COLUMN_NAME_IMAGE} TEXT)"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FlagsReaderContract.FeedEntry.TABLE_NAME}"

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