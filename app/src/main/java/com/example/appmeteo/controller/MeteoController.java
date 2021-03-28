package com.example.appmeteo.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.widget.ImageView;

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
        //Bitmap bitmap = requestImage(meteo.getWeather()[0].getIcon());
        //return PlacesHolder.get(context).addPlace(text.toString(), null,meteo,bitmap);
        return PlacesHolder.get(context).addPlace(text.toString(), null,meteo,null);

    }

    public Place requestMeteoByCoordinates(double lat,double lon, Context context){


        Meteo meteo = jsonToMeteo(ConnectionController.getConnectionController().getWeatherByCoordinates(lat,lon));
        //Bitmap bitmap = requestImage(meteo.getWeather()[0].getIcon());
        PlacesHolder.get(context).getPlaces().get(0).setMeteo(meteo);
        PlacesHolder.get(context).getPlaces().get(0).setName(meteo.getName());
        //PlacesHolder.get(context).getPlaces().get(0).setBitmap(bitmap);

        return null;
    }


    /*public Bitmap requestImage(String imageId){

        String  str = ConnectionController.getConnectionController().getImageById(imageId);

        //return BitmapFactory.decodeStream();
        return null;
    }*/


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
/*

 */