package com.example.appmeteo.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appmeteo.model.Place;

import java.util.ArrayList;
import java.util.List;

public class DbWrapper {
    private SQLiteDatabase database;

    public DbWrapper(Context context) {
        this.database = new DbHelper(context).getWritableDatabase();
    }
    public long insert(Place place){
        ContentValues contentValues= new ContentValues();
        contentValues.put(DbScheme.PlacesTable.Cols.UUID, place.getUuid().toString());
        contentValues.put(DbScheme.PlacesTable.Cols.NAME, place.getName());
        return database.insert(DbScheme.PlacesTable.NAME,null, contentValues);
    }
    public List<Place> loadData() {
        Cursor c = database.query(DbScheme.PlacesTable.NAME, null, null, null, null, null, null);
        PlaceCursorWrapper cursor = new PlaceCursorWrapper(c);
        List<Place> places=new ArrayList<>();
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Place place = cursor.getEntry();
                places.add(place);
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return places;
    }
}
