package com.example.lakwatsaph;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

public class DataConn extends SQLiteOpenHelper {
    public static final String DB_NAME = "travelapp.db";
    public static final String users = "users";
    public static final String Col_Username = "username";
    public static final String Col_Password = "password";
    public static final String Col_Email = "email";
    public DataConn(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table users(username VARHCAR(17) PRIMARY KEY, password VARCHAR(255) NOT NULL, email varchar(30) NOT NULL)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop Table if exists users");
    }

    public Boolean insertAcc(String user, String pass, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
         val.put(Col_Username, user);
         val.put(Col_Password, pass);
         val.put(Col_Email, email);

         long result = db.insert(users, null, val);
         if(result == -1) return false;
         else
             return true;
    }
    
    public Cursor checkUser(String user, String pass) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * from users WHERE username =  '" + user + "' AND password = '" + pass + "'", null);
        return cursor;
    }
}
