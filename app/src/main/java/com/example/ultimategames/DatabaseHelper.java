package com.example.ultimategames;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "people_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    // private static final String COL3 = "word";

    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT)";
        Log.d(TAG, "onCreate function!!");
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
    }

    public boolean addData(String item){
        // Anlage sql database object
        SQLiteDatabase db = this.getWritableDatabase();
        // Then we declare a content value object which is going to help us to write to the database
        ContentValues contentValues = new ContentValues();
        // Then we add our first value to content value
        contentValues.put(COL2, item);
        // Just an Log
        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        // And we create a veriable to check if the value was inserted correctly
        long result = db.insert(TABLE_NAME, null, contentValues);

        // wenn fehler beim einfügen -1
        if (result == -1){
            return false;
        }else
        {
            return true;
        }
    }

}
