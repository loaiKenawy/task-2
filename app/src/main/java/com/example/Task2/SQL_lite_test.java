package com.example.Task2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQL_lite_test extends SQLiteOpenHelper {

    public static final String dataBaseName = "database Test";
//create the database
    public SQL_lite_test(@Nullable Context context) {
        super(context, dataBaseName, null, 1);
    }


//In this method the query is executed
//creating the tables in the database using SQL commands
    @Override
    public void onCreate(SQLiteDatabase db) {



    }
//this method update the database or data in the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
