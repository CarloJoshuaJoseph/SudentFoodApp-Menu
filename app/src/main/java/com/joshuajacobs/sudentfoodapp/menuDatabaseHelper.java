package com.joshuajacobs.sudentfoodapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class menuDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "snacks.db";
    private static final int DATABASE_VERSION = 1;

    public menuDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the "snacks" table
        String createTableQuery = "CREATE TABLE IF NOT EXISTS snacks (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "price REAL)";
        db.execSQL(createTableQuery);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade if needed
    }

}
