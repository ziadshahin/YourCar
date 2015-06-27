package com.example.ziad.yourcar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ziad on 22/06/2015.
 */public class DBHelper extends SQLiteOpenHelper {
        private static String DATABASE_NAME = "Carsdb.sqlite";

        private static int DATABASE_VERSION = 1;

        public DBHelper(Context C) {
            super(C, DATABASE_NAME, null, DATABASE_VERSION);

        }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {}


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) { }

}

