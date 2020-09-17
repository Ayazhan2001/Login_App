package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DatabaseStore extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "registration.db";
    public static final  int DATABASE_VERSION = 2;

    public static final String TABLE_USER = "user_store";

    public static final String COLUMN_INFO = "user_full_name";
    public static final String COLUMN_EMAIL = "user_email";
    public static final String COLUMN_NUMBER = "user_number";
    public static final String COLUMN_PASSWORD = "user_password";

    Context context;

    public DatabaseStore(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_USER + "(" +
                COLUMN_INFO + "TEXT, " +
                COLUMN_EMAIL + "TEXT, " +
                COLUMN_PASSWORD + "TEXT, " +
                COLUMN_NUMBER + "TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        onCreate(db);
    }
}
