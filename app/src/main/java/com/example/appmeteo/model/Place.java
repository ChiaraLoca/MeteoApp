package com.example.appmeteo.model;

import android.location.Location;

import java.util.UUID;

public class Place {
    private final UUID uuid;
    private final Location location;
    private final String name;

    public UUID getUuid() {
        return uuid;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public Place(UUID uuid, Location location, String name) {
        this.uuid = uuid;
        this.location = location;
        this.name = name;
    }
}
