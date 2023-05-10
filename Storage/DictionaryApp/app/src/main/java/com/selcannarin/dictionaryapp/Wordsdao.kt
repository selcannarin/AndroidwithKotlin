package com.selcannarin.dictionaryapp

class Wordsdao {

    fun getAllWords(db:WordsDbHelper) : ArrayList<Words>{
        val wordsList = ArrayList<Words>()
        val w = db.writableDatabase
        val cursor = w.rawQuery("SELECT * FROM Words", null)

        while(cursor.moveToNext()){
            val word = Words(cursor.getInt(cursor.getColumnIndexOrThrow("word_id"))
            ,cursor.getString(cursor.getColumnIndexOrThrow("english"))
            ,cursor.getString(cursor.getColumnIndexOrThrow("turkish")))

            wordsList.add(word)
        }
        return wordsList
    }

    fun getSearchedWord(db:WordsDbHelper, searchedWord:String) : ArrayList<Words>{
        val wordsList = ArrayList<Words>()
        val w = db.writableDatabase
        val cursor = w.rawQuery("SELECT * FROM Words WHERE english like '%$searchedWord%'", null)

        while(cursor.moveToNext()){
            val word = Words(cursor.getInt(cursor.getColumnIndexOrThrow("word_id"))
                ,cursor.getString(cursor.getColumnIndexOrThrow("english"))
                ,cursor.getString(cursor.getColumnIndexOrThrow("turkish")))

            wordsList.add(word)
        }
        return wordsList
    }

}

