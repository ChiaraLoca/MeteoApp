using MeteoAppSkeleton.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace MeteoAppSkeleton.ViewModels
{
    class MeteoItemViewModel : BaseViewModel
    {
        Place _place;
        public Place Place
        {
            get { return _place; }
            set
            {
                _place = value;
                OnPropertyChanged();
            }
        }
        public MeteoItemViewModel(Place place)
        {
            Place = place;
        }
    }
}
