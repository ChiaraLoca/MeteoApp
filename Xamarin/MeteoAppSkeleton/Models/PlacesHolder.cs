using Plugin.Geolocator;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.Models
{
    public class PlacesHolder
    {
        private List<Place> places;
        //private DbWrapper dbWrapper;
        private static PlacesHolder instance = null;
        //Todo controllare il multithread
        //private ExecutorService executorService;
        public List<Place> getPlaces()
        {
            return places;
        }

        public static PlacesHolder get()
        {
            if (instance == null)
            {
                instance = new PlacesHolder();
                //instance.executorService.submit(()->instance.places.addAll(instance.dbWrapper.loadData()));
            }
            return instance;
        }
        private PlacesHolder( )
        {
            /*this.places = new CopyOnWriteArrayList<>();
            this.dbWrapper = new DbWrapper(context);
            this.executorService = Executors.newSingleThreadExecutor();*/
            this.places = new List<Place>();
            places.Add(new Place(Guid.NewGuid(), "LOCAL"));
        }

        public Place addPlace(String name, CrossGeolocator location, Meteo meteo)
        {
            Place p = new Place(Guid.NewGuid(), location, name, meteo);
            places.Add(p);
            //executorService.submit(()->dbWrapper.insert(p));
            return p;
        }

        public Place getPlaceByUUID(Guid uuid)
        {
            foreach (Place p in places)
            {
                if (p.uuid.Equals(uuid))
                    return p;
            }
            return null;
        }
    }
}
