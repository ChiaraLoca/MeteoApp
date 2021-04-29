package com.example.appmeteo.controller;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.example.appmeteo.fragments.placesList.PlaceHolder;
import com.example.appmeteo.model.PlacesHolder;
import com.example.appmeteo.model.meteo.Meteo;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

public class GPSController {
    private static GPSController instance=null;

    public static GPSController getInstance() {
        if(instance==null)
            instance= new GPSController();
        return instance;
    }

    private GPSController() {
    }
    public void startLocationListener(Context context) {

        long mLocTrackingInterval = 1000 * 600; // 10 minuti
        float trackingDistance = 0;
        LocationAccuracy trackingAccuracy = LocationAccuracy.HIGH;

        LocationParams.Builder builder = new LocationParams.Builder()
                .setAccuracy(trackingAccuracy)
                .setDistance(trackingDistance)
                .setInterval(mLocTrackingInterval);

        SmartLocation.with(context)
                .location()
                .continuous()
                .config(builder.build())
                .start(new OnLocationUpdatedListener() {
                    @Override
                    public void onLocationUpdated(Location location) {
                        Log.i("GPS", "location" + location);
                        if(PlacesHolder.get(context).getPlaces().get(0).getLocation()==null || !PlacesHolder.get(context).getPlaces().get(0).getLocation().equals(location)){
                            PlacesHolder.get(context).getPlaces().get(0).setLocation(location);
                            MeteoController.getInstance().requestMeteoByCoordinates(PlacesHolder.get(context).getPlaces().get(0).getLocation().getLatitude(),PlacesHolder.get(context).getPlaces().get(0).getLocation().getLongitude(),context);
                            TemperatureCheckController.getInstance().startCheck(context);
                        }
                    }
                });
    }
}
