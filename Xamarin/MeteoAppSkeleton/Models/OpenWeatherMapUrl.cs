using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.Models
{
    public class OpenWeatherMapUrl 
    {

    private  String key = "7ddde84d539794606c350736562fab25";
    private  String initWeather = "https://api.openweathermap.org/data/2.5/weather?";
    private  String initImage = "http://openweathermap.org/img/wn/";
    private  String endImage = "@2x.png";

    
    public String getUrlByCoordinates(double lat, double lon)
    {
        return initWeather + "lat=" + lat + "&lon=" + lon + "&appid=" + key;
    }

    
    public String getUrlByCityNames(String cityName)
    {
        return initWeather + "q=" + cityName + "&appid=" + key;
    }

   
    public String getUrlImageById(String imageId)
    {
        return initImage + imageId + endImage;
    }
}
}
