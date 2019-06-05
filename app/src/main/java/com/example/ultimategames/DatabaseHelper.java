package com.example.ultimategames;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    public static final int DATABASE_VERSION = 2;


    private static final String TABLE_NAME = "words";
    private static final String COL_ID = "ID";
    private static final String COL_WORD = "word";

    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_WORD + " TEXT UNIQUE)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_WORD, item);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }else
        {
            return true;
        }
    }

    public boolean deleteWord(String word)
    {
        String where = "word=?";
        SQLiteDatabase db = this.getWritableDatabase();
        int numberOFEntriesDeleted = db.delete(TABLE_NAME, where, new String[]{word});

        return numberOFEntriesDeleted > 0;
    }

    public ArrayList<String> getAllWords()
    {
        ArrayList wordList = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_WORD + " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor query = db.rawQuery(selectQuery, null);

        if (query.moveToFirst())
        {
            do
            {
                wordList.add(query.getString(1));
            }
            while (query.moveToNext());
        }

        return wordList;
    }
}
