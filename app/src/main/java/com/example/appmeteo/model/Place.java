package com.example.appmeteo.model;

import android.graphics.Bitmap;
import android.location.Location;

import com.example.appmeteo.controller.MeteoController;
import com.example.appmeteo.model.meteo.Meteo;

import java.util.UUID;

public class Place {
    private final UUID uuid;

    public void setLocation(Location location) {
        this.location = location;
    }

    private Location location;
    private Meteo meteo;
    private String name;
    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public Meteo getMeteo() {
        return meteo;
    }

    public void setMeteo(Meteo meteo) {
        this.meteo = meteo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place(UUID uuid, Location location, String name, Meteo meteo,Bitmap bitmap) {
        this.uuid = uuid;
        this.location = location;
        this.name = name;
        this.meteo = meteo;
        this.bitmap = bitmap;
    }


    public void updateMeteo(String s) {
        this.meteo= MeteoController.getInstance().jsonToMeteo(s);
    }
}
