using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.Models
{
    public class Wind
    {
        [JsonProperty("speed")]
        private double speed { get; set; }
        [JsonProperty("deg")]
        private double deg { get; set; }

       
        override public String ToString()
        {
            return "Wind{" +
                    "speed=" + speed +
                    ", deg=" + deg +
                    '}';
        }

        public Wind()
        {
        }

        public Wind(double speed, double deg)
        {
            this.speed = speed;
            this.deg = deg;
        }


    }
}
