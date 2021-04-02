package com.example.appmeteo.model.db;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.appmeteo.model.Place;

import java.util.UUID;

public class PlaceCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public PlaceCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Place getEntry(){
        UUID uuid = UUID.fromString(getString(getColumnIndex(DbScheme.PlacesTable.Cols.UUID)));
        String name = getString(getColumnIndex(DbScheme.PlacesTable.Cols.NAME));
        return new Place(uuid, name);
    }
}
