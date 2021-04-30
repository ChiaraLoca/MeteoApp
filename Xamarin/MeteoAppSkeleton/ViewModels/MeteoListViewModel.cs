using System;
using System.Collections.ObjectModel;
using MeteoAppSkeleton.Models;
using Plugin.Geolocator;

namespace MeteoAppSkeleton.ViewModels
{
    public class MeteoListViewModel : BaseViewModel
    {
        private static MeteoListViewModel instance=null;
        public static MeteoListViewModel getInstance()
        {
            if (instance == null)
                instance = new MeteoListViewModel();
            return instance;

        }
        
        ObservableCollection<Place> _metoeList;

        public ObservableCollection<Place> Entries
        {
            get { return _metoeList; }
            set
            {
                _metoeList = value;
                OnPropertyChanged();
            }
        }

        private MeteoListViewModel()
        {
            Entries = new ObservableCollection<Place>();

            for (var i = 0; i < 2; i++)
            {
                Entries.Add(new Place(Guid.NewGuid(), "Locale"+i));
            }
        }

        public void add(Place p)
        {
            Entries.Add(p);
        }
       
    }
}