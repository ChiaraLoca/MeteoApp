package com.example.appmeteo.controller;

import android.content.Context;

import com.example.appmeteo.controller.connection.ConnectionController;
import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.PlacesHolder;

import com.example.appmeteo.model.meteo.Meteo;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;


import java.io.IOException;


public class MeteoController {

    private static MeteoController instance=null;
    public static MeteoController getInstance(){
        if(instance==null)
            instance=new MeteoController();
        return instance;
    }
    private MeteoController(){

    }


    public Place requestMeteoByPlace(CharSequence text, Context context){


        Meteo meteo = jsonToMeteo(ConnectionController.getConnectionController().getWeatherByCityName(text.toString()));
        if(meteo ==null)
            return null;
        return PlacesHolder.get(context).addPlace(text.toString(), null,meteo);

    }

    public Place requestMeteoByCoordinates(double lat,double lon, Context context){
        Meteo meteo = jsonToMeteo(ConnectionController.getConnectionController().getWeatherByCoordinates(lat,lon));
        PlacesHolder.get(context).getPlaces().get(0).setMeteo(meteo);
        if(!meteo.getName().isEmpty())
            PlacesHolder.get(context).getPlaces().get(0).setName(meteo.getName());

        return null;
    }
    public Meteo jsonToMeteo(String s){
        Meteo meteo=null;

        Moshi moshi= new Moshi.Builder().build();
        JsonAdapter<Meteo> jsonAdapter= moshi.adapter(Meteo.class);
        try {
            meteo = jsonAdapter.fromJson(s);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return meteo;
    }
}
