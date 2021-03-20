package com.example.appmeteo.controller;

import android.content.Context;

import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.PlacesHolder;

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
}
