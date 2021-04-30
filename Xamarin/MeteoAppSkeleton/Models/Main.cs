using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.Models
{
    public class Main
    {
        [JsonProperty("temp")]
        private double temp { get; set; }
        
        [JsonProperty("feels_like")]
        private double feels_like { get; set; }
        
        [JsonProperty("temp_min")]
        private double temp_min { get; set; }
        
        [JsonProperty("temp_max")]
        private double temp_max { get; set; }
        
        [JsonProperty("pressure")]
        private double pressure { get; set; }
        
        [JsonProperty("humidity")]
        private double humidity { get; set; }
        


        override public String ToString()
        {
            return "minimum temperature:" + temp_min +
                    "\ncurrent temperature:" + temp +
                    "\nmaximum temperature:" + temp_max;


           
        }

        public Main()
        {
        }

        public Main(double temp, double feels_like, double temp_min, double temp_max, double pressure, double humidity)
        {
            this.temp = temp;
            this.feels_like = feels_like;
            this.temp_min = temp_min;
            this.temp_max = temp_max;
            this.pressure = pressure;
            this.humidity = humidity;
        }
    }

}
