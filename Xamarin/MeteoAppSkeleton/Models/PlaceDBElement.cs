using MeteoAppSkeleton.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppXF.Models
{
    public class PlaceDBElement
    {
        public Guid uuid { get; set; }
        public String name { get; set; }

        public PlaceDBElement()
        {

        }

        public PlaceDBElement(Place place)
        {
            this.uuid = place.uuid;
            this.name = place.name;
        }
    }
}
