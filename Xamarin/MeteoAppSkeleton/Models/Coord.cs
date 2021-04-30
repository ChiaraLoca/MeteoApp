using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.Models
{
    public class Coord
    {
        [JsonProperty("lon")]
        private double lon { get; set; }

        [JsonProperty("lat")]
        private double lat { get; set; }

        public Coord()
        {
        }

        public Coord(double lon, double lat)
        {
            this.lon = lon;
            this.lat = lat;
        }

        override public String ToString()
        {
            return "Coordinates" + lon + "," + lat;
        }


    }
}
