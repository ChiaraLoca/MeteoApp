using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.Models
{
    public class Clouds
    {
        [JsonProperty("all")]
        private double all { get; set; }

        override public String ToString()
        {
            return "Clouds{" +
                    "all=" + all +
                    '}';
        }
        public Clouds(){ }

        public Clouds(double all)
        {
            this.all = all;
        }

    }
}
