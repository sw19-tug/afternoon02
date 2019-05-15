package com.example.ultimategames;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "words";
    private static final String COL_ID = "ID";
    private static final String COL_WORD = "word";

    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_WORD + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
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
