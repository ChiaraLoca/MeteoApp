package com.example.appmeteo.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String dbName= "meteoAppDB";
    private static final int version = 1;
    public DbHelper(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DbScheme.PlacesTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                DbScheme.PlacesTable.Cols.UUID +
                ", " +
                DbScheme.PlacesTable.Cols.NAME +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
