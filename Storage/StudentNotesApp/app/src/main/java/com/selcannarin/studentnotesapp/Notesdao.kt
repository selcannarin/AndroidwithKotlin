package com.selcannarin.studentnotesapp

import android.content.ContentValues

class Notesdao {

    fun allNotes(dbHelper: NotesDbHelper) : ArrayList<Notes>{
        val db = dbHelper.writableDatabase
        val notesList = ArrayList<Notes>()
        val cursor = db.rawQuery("SELECT * FROM Notes",null)

        while(cursor.moveToNext()){
            val note = Notes(cursor.getInt(cursor.getColumnIndexOrThrow("student_id"))
                ,cursor.getString(cursor.getColumnIndexOrThrow("student_name"))
                ,cursor.getInt(cursor.getColumnIndexOrThrow("note1"))
                ,cursor.getInt(cursor.getColumnIndexOrThrow("note2")))

            notesList.add(note)
        }
        return notesList
    }

    fun addNote(dbHelper: NotesDbHelper,student_name:String, note1:Int, note2:Int){
        val db = dbHelper.writableDatabase

        val values = ContentValues()
        values.put("student_name",student_name)
        values.put("note1",note1)
        values.put("note2",note2)

        db.insertOrThrow("Notes",null,values)
        db.close()
    }

    fun deleteNote(dbHelper: NotesDbHelper, student_id:Int){
        val db = dbHelper.writableDatabase
        db.delete("Notes","student_id=?", arrayOf(student_id.toString()))
        db.close()
    }

    fun editNote(dbHelper: NotesDbHelper,student_id: Int,student_name:String, note1:Int, note2:Int){
        val db = dbHelper.writableDatabase

        val values = ContentValues()
        values.put("student_name",student_name)
        values.put("note1",note1)
        values.put("note2",note2)

        db.update("Notes",values,"student_id=?", arrayOf(student_id.toString()))
        db.close()
    }
}