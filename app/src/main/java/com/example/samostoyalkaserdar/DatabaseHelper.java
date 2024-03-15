package com.example.samostoyalkaserdar;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "main.db";
    private static final int SCHEMA = 1;
    static final String TABLE = "Fruits";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_QUAN = "Quantity";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + " (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT, " + COLUMN_QUAN + " INTEGER);");
        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_NAME + ", "
                + COLUMN_QUAN + ") VALUES ('Бананчики', 200);");
        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_NAME + ", "
                + COLUMN_QUAN + ") VALUES ('Яблоко', 100);");
        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_NAME + ", "
                + COLUMN_QUAN + ") VALUES ('Груша', 150);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}