
using MeteoAppSkeleton.Controller;
using MeteoAppSkeleton.Models;
using MeteoAppSkeleton.ViewModels;
using System;
using Xamarin.Forms;

namespace MeteoAppSkeleton.Views
{
    partial class AddNewLocation : ContentPage
    {
        public string EntryText { get; set; } = "My Label Text";
        public AddNewLocation() { 
            InitializeComponent(); 
        }

        async void OnButtonClicked(object sender, EventArgs args)
        {

            string t;
            await DisplayAlert("Valication location "+ (t=EntryLocation.Text) + ", plase wait", "", "OK");

            if (t != null)
            {

                MeteoController meteoController = MeteoController.getInstance();


                Place place = meteoController.requestMeteoByPlace(t);
                if (place == null)
                    await DisplayAlert("Location " + t + " not found", "", "OK");
                else
                {
                    await DisplayAlert("Location " + t + " added", "", "OK");
                    MeteoListViewModel.getInstance().add(place);

                }
            }

            

        }
    }
}
