package com.example.appmeteo.model.url;

public interface WeatherUrl {
    public String getUrlByCoordinates(double lat, double lon);
    public String getUrlByCityNames(String cityName);
    public String getUrlImageById(String imageId);
}
