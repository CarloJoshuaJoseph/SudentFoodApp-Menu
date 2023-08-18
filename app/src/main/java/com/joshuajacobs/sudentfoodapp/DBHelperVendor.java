package com.joshuajacobs.sudentfoodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperVendor extends SQLiteOpenHelper {

    public static final String DBNAME = "StudentFood.db";
    public DBHelperVendor(Context context) {
        super(context, "StudentFood.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE vendors(username TEXT PRIMARY KEY, restaurant_name TEXT, password TEXT)");
        MyDB.execSQL("create Table clients(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists vendors");
        MyDB.execSQL("drop Table if exists clients");
    }

    public Boolean insertData(String username, String restaurantName, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("restaurant_name", restaurantName);
        contentValues.put("password", password);
        long result = MyDB.insert("vendors", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from vendors where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from vendors where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
