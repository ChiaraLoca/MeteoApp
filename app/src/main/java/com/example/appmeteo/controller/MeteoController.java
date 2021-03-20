package com.example.appmeteo.controller;

import android.content.Context;

import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.PlacesHolder;
import com.example.appmeteo.model.meteo.Meteo;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

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
        try {
            BufferedReader bufferedReader= new BufferedReader(new StringReader(s));
            JsonObject jsonObject= (JsonObject) Jsoner.deserialize(bufferedReader);
            Mapper mapper= DozerBeanMapperBuilder.buildDefault();
            meteo= mapper.map(jsonObject, Meteo.class);
            bufferedReader.close();
        } catch (JsonException | IOException e) {
            e.printStackTrace();
        }
        return meteo;
    }
}
