package com.example.appmeteo.model.url;

public class OpenWeatherMapUrl implements WeatherUrl{

    private final String key = "7ddde84d539794606c350736562fab25";
    private final String initWeather = "https://api.openweathermap.org/data/2.5/weather?";
    private final String initImage = "http://openweathermap.org/img/wn/";
    private final String endImage = "@2x.png";

    @Override
    public String getUrlByCoordinates(double lat, double lon) {
        return initWeather+"lat="+lat+"&lon="+lon+"&appid="+key;
    }

    @Override
    public String getUrlByCityNames(String cityName) {
        return initWeather+"q="+cityName+"&appid="+key;
    }

    @Override
    public String getUrlImageById(String imageId) {
        return initImage+imageId+endImage;
    }
}
