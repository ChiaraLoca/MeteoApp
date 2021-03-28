package com.example.appmeteo.controller;

import com.example.appmeteo.model.url.OpenWeatherMapUrl;
import com.example.appmeteo.model.url.WeatherUrl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class ConnectionController {

    private static ConnectionController connectionController=null;
    private WeatherUrl weatherUrl = new OpenWeatherMapUrl();
    private ConnectionController() {}
    public static ConnectionController getConnectionController() {
        if(connectionController==null)
            connectionController = new ConnectionController();
        return connectionController;
    }
    public String getWeatherByCoordinates(double lat, double lon)
    {
        return send(weatherUrl.getUrlByCoordinates(lat,lon));
    }
    public String getWeatherByCityName(String cityName)
    {
        return send(weatherUrl.getUrlByCityNames(cityName));
    }
    /*public String getImageById(String imageId)
    {

        return send(weatherUrl.getUrlImageById(imageId));

    }*/


    private String send(String urlstr)
    {

       String str=null;
        try {
            Send send = (Send) new Send().execute(urlstr);
            str= send.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return str;

        /*StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection connection=null;
        try {
            URL url = new URL(urlstr);
             connection = (HttpURLConnection)url.openConnection();
            InputStream in = connection.getInputStream(); // apro la connessione
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK)
                return null;
            String line;
            while((line =bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            connection.disconnect();
        }
        return stringBuilder.toString();*/
    }



}
