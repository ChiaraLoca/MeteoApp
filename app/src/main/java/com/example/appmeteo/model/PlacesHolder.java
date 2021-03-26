package com.example.appmeteo.model;

import android.content.Context;
import android.location.Location;

import com.example.appmeteo.model.db.DbWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlacesHolder {
    private List<Place> places;
    private DbWrapper dbWrapper;
    private static PlacesHolder instance=null;
    private ExecutorService executorService;
    public List<Place> getPlaces() {
        return places;
    }

    public static PlacesHolder get(Context context){
        if (instance==null) {
            instance = new PlacesHolder(context);
            instance.executorService.submit(() -> instance.places.addAll(instance.dbWrapper.loadData()));
        }
        return instance;
    }
    private PlacesHolder(Context context) {
        this.places = new CopyOnWriteArrayList<>();
        this.dbWrapper= new DbWrapper(context);
        this.executorService= Executors.newSingleThreadExecutor();
        places.add(new Place(UUID.randomUUID(), "LOCAL"));
    }

    public Place addPlace(String name){
        Place p=new Place(UUID.randomUUID(), name);
        places.add(p);
        executorService.submit(() -> dbWrapper.insert(p));
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
