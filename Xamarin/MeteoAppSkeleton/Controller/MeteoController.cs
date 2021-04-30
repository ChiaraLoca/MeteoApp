using MeteoAppSkeleton.Models;
using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using System.Diagnostics;

namespace MeteoAppSkeleton.Controller
{
    public class MeteoController
    {

        private static MeteoController instance = null;
        public static MeteoController getInstance()
        {
            if (instance == null)
            {
                instance = new MeteoController();
                return instance;
            }
            else
                return instance;
        }
        private MeteoController(){}


        public Place requestMeteoByPlace(String text)
        {


            Meteo meteo = jsonToMeteo(ConnectionController.getConnectionController().getWeatherByCityName(text.ToString()));
            if (meteo == null)
                return null;
            return new Place(Guid.NewGuid(),null,text.ToString(), meteo);

        }

        public Place requestMeteoByCoordinates(double lat, double lon)
        {
            Meteo meteo = jsonToMeteo(ConnectionController.getConnectionController().getWeatherByCoordinates(lat, lon));
            PlacesHolder.get().getPlaces()[0].meteo= meteo;
            PlacesHolder.get().getPlaces()[0].name = meteo.name;

            return null;
        }
        public Meteo jsonToMeteo(String s)
        {

            
            Meteo meteo = JsonConvert.DeserializeObject<Meteo>(s);

            return meteo;
        }
     }
}
