package com.example.appmeteo.controller;

import android.content.Context;

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
    public Place requestPlace(CharSequence text, Context context){
        //TODO usare API del sito
        return PlacesHolder.get(context).addPlace(text.toString(), null);
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
