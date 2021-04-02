package com.example.appmeteo.controller.connection;

import com.example.appmeteo.model.url.OpenWeatherMapUrl;
import com.example.appmeteo.model.url.WeatherUrl;

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


    }



}
