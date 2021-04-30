using System;
using System.Collections.ObjectModel;
using MeteoAppSkeleton.Models;
using MeteoAppXF.Controller;
using MeteoAppXF.Models;

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

        private DBController db;
        
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
            db = DBController.get();
            Entries = new ObservableCollection<Place>();
            Entries.Add(new Place(Guid.NewGuid(), "Locale"));
            var dbEntries = db.GetItemsAsync().Result;
            dbEntries.ForEach((p) => { Entries.Add(new Place(p)); });
        }

        public void add(Place p)
        {
            Entries.Add(p);
            DBController.get().SaveItemAsync(new PlaceDBElement(p));
        }
       
    }
}