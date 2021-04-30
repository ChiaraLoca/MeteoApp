using MeteoAppSkeleton.Controller;
using Plugin.Geolocator;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.Models
{
    public class Place
    {
        public Guid uuid { get; set; }
        public CrossGeolocator location { get; set; }
        public Meteo meteo { get; set; }
        public String name { get; set; }

        public Place(Guid uuid, CrossGeolocator location, String name, Meteo meteo)
        {
            this.uuid = uuid;
            this.location = location;
            this.name = name;
            this.meteo = meteo;

        }
      
        public Place(Guid uuid, String name)
        {
            this.uuid = uuid;
            this.name = name;
        }

        public void updateMeteo(String s)
        {
            this.meteo = MeteoController.getInstance().jsonToMeteo(s);
        }
    }
}
