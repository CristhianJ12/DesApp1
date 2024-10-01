package com.example.proymenu

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

//Revisar este codigo con chatgpt

class LibrosDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_NAME = "librosapp.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "libros"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_AUTOR = "autor"
        private const val COLUMN_PAGES = "pages"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_TITLE TEXT, $COLUMN_AUTOR TEXT ,$COLUMN_PAGES INTEGER)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun insertLibro(libro: Libros){
        val db = writableDatabase
        val values = contentValuesOf().apply {
            put(COLUMN_TITLE, libro.title)
            put(COLUMN_AUTOR, libro.autor)
            put(COLUMN_PAGES, libro.pages)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllLibros(): List<Libros> {
        val librosList = mutableListOf<Libros>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query,null)

        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            val autor = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AUTOR))
            val pages = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_PAGES))

            val libro = Libros(id,title, autor, pages)
            librosList.add(libro)
        }
        cursor.close()
        db.close()
        return librosList
    }

    fun updateLibro(libro: Libros){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE, libro.title)
            put(COLUMN_AUTOR, libro.autor)
            put(COLUMN_PAGES, libro.pages)
        }
        val whereClause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(libro.id.toString())
        db.update(TABLE_NAME,values, whereClause, whereArgs)
        db.close()
    }

    fun getLibroByID(libroId: Int): Libros{
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = $libroId"
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()

        val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
        val title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
        val autor = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AUTOR))
        val pages = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_PAGES))

        cursor.close()
        db.close()
        return Libros(id,title,autor,pages)
    }

    fun deleteLibro(libroId: Int){
        val db = writableDatabase
        val whereclause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(libroId.toString())
        db.delete(TABLE_NAME, whereclause, whereArgs)
        db.close()
    }
}
