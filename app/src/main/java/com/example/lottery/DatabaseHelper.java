package com.example.lottery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myDatabase.db";
    public static final String TABLE_NAME = "user";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";

    private final String username = "test";
    private final String password = "123";
    private static final String TAG = "LoginActivity";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USER = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";
        db.execSQL(CREATE_TABLE_USER);

         Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        if (res.getCount() == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2, username);
            contentValues.put(COL_3, password);
            long result = db.insert(TABLE_NAME, null, contentValues);
            if (result == -1) {
                Log.d(TAG, "record not added");
            } else {
                Log.d(TAG, "record added");
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}