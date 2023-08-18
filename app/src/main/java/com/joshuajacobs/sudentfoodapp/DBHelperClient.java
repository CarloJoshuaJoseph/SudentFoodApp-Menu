package com.joshuajacobs.sudentfoodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperClient extends SQLiteOpenHelper {

    public static final String DBNAME = "StudentFood.db";
    public DBHelperClient(Context context) {
        super(context, "StudentFood.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table clients(username TEXT primary key, password TEXT)");
        MyDB.execSQL("CREATE TABLE vendors(username TEXT PRIMARY KEY, restaurant_name TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists clients");
        MyDB.execSQL("drop Table if exists vendors");

    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("clients", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from clients where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from clients where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
