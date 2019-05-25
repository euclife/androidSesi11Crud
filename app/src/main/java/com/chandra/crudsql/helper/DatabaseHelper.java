package com.chandra.crudsql.helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Kampus.db";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableUser = "CREATE TABLE user ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nama TEXT NOT NULL,"+
                "password TEXT NOT NULL,"+
                "is_login INTEGER NOT NULL,"+
                "role INTEGER NOT NULL)";
        db.execSQL(tableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }
}
