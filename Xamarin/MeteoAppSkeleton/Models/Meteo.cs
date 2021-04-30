using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.Models
{
    public class Meteo
    {
        [JsonProperty("coord")]
        public Coord coord { get; set; }

        [JsonProperty("weather")]
        public Weather[] weather { get; set; }

        [JsonProperty("base")]
        public String Base{ get; set; }

        [JsonProperty("main")]
        public Main main { get; set; }
        
        [JsonProperty("wind")]
        public Wind wind { get; set; }
        [JsonProperty("clouds")]
        public Clouds clouds { get; set; }
        [JsonProperty("dt")]
        public long dt { get; set; }
        [JsonProperty("sys")]
        public Sys sys { get; set; }
        [JsonProperty("timezone")]
        public long timezone { get; set; }
        [JsonProperty("id")]
        public long id { get; set; }
        [JsonProperty("name")]
        public String name { get; set; }
        [JsonProperty("cod")]
        public long cod { get; set; }

       

        public Meteo()
        {
        }

        public Meteo(Coord coord, Weather[] weather, String Base, Main main, Wind wind, Clouds clouds, long dt, Sys sys, long timezone, long id, String name, long cod)
        {
            this.coord = coord;
            this.weather = weather;
            this.Base = Base;
            this.main = main;
            this.wind = wind;
            this.clouds = clouds;
            this.dt = dt;
            this.sys = sys;
            this.timezone = timezone;
            this.id = id;
            this.name = name;
            this.cod = cod;
        }


       override public string ToString()
        {
           
            return "Meteo{" +
                    "coord=" + coord +
                    ", weather=" + string.Join(",", weather.ToString()) +
                    ", base='" + Base + '\'' +
                    ", main=" + main +
                    ", wind=" + wind +
                    ", clouds=" + clouds +
                    ", dt=" + dt +
                    ", sys=" + sys +
                    ", timezone=" + timezone +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", cod=" + cod +
                    '}';
        }
    }
}
