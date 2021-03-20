package com.example.appmeteo.model;

import android.content.Context;
import android.location.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlacesHolder {
    private List<Place> places;
    private static PlacesHolder instance=null;

    public List<Place> getPlaces() {
        return places;
    }

    public static PlacesHolder get(Context context){
        if (instance==null)
            instance=new PlacesHolder(context);
        return instance;
    }
    private PlacesHolder(Context context) {
        this.places = new ArrayList<>();
        places.add(new Place(UUID.randomUUID(), null, "QUI"));
    }

    public Place addPlace(String name, Location location){
        Place p=new Place(UUID.randomUUID(), location, name);
        places.add(p);
        return p;
    }

    public Place getPlaceByUUID(UUID uuid){
        for (Place p: places) {
            if(p.getUuid().equals(uuid))
                return p;
        }
        return null;
    }
}
