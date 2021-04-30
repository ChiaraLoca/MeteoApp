using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.Models
{
    public class Sys
    {
        [JsonProperty("coord")]
        private long type { get; set; }
        [JsonProperty("id")]
        private long id { get; set; }
        [JsonProperty("message")]
        private double message { get; set; }
        [JsonProperty("country")]
        private String country { get; set; }
        [JsonProperty("sunrise")]
        private long sunrise { get; set; }
        [JsonProperty("sunset")]
        private long sunset { get; set; }


        override public String ToString()
        {
            return "Sys{" +
                    "type=" + type +
                    ", id=" + id +
                    ", message=" + message +
                    ", country='" + country + '\'' +
                    ", sunrise=" + sunrise +
                    ", sunset=" + sunset +
                    '}';
        }

        public Sys(long type, long id, double message, String country, long sunrise, long sunset)
        {
            this.type = type;
            this.id = id;
            this.message = message;
            this.country = country;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }


    }
}
